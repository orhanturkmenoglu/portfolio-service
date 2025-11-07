package com.example.portfolio.service.core.export.service;

import java.io.OutputStream;

public interface PdfGeneratorService {

    void generateCvPdf(OutputStream outputStream);
}
