package com.example.portfolio.service.core.export.controller;

import com.example.portfolio.service.core.export.service.PdfGeneratorService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/export")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExportController {

    private final PdfGeneratorService pdfGeneratorService;

    @GetMapping("/pdf")
    public void exportCvAsPdf(HttpServletResponse response)throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","attachment;filename=cv.pdf");
        pdfGeneratorService.generateCvPdf(response.getOutputStream());
    }
}
