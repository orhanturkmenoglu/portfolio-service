package com.example.portfolio.service.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class RegexEmailValidator implements ConstraintValidator<RegexEmail,String> {

    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
       if(email !=null) {
           return EMAIL_REGEX.matcher(email).matches();
       }
       return false;
    }
}
