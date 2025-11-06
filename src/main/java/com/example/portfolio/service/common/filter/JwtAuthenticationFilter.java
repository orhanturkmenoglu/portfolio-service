package com.example.portfolio.service.common.filter;

import com.example.portfolio.service.common.utils.JwtUtil;
import com.example.portfolio.service.core.user.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private static  final List<String> EXCLUDE_URL =List.of(
            "/auth/login",
            "/auth/register"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

      String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
      String token ;
      String username ;



      if (authHeader == null || !authHeader.startsWith("Bearer ")){
          filterChain.doFilter(request, response);
          return;
      }

      token = authHeader.substring(7);
      username = jwtUtil.extractUsername(token);


      if (username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
          var user =  userDetailsService.loadUserByUsername(username);

          if (jwtUtil.isValidToken(token,user)){
              var authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
              authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(authToken);
          }

      }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
         return EXCLUDE_URL.stream()
                .anyMatch(url->antPathMatcher.match(url, request.getServletPath()));
    }
}
