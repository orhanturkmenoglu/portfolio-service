package com.example.portfolio.service.core.export.service.impl;

import com.example.portfolio.service.common.utils.PdfUtils;
import com.example.portfolio.service.core.export.service.PdfGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class PdfGeneratorServiceImpl implements PdfGeneratorService {

    private final PdfUtils pdfUtils;

    @Cacheable(value = "cvPdf")
    @Override
    public void generateCvPdf(OutputStream outputStream) {
        log.info("Generating CV PDF");
        pdfUtils.createSampleCvPdf(outputStream);
    }
}
