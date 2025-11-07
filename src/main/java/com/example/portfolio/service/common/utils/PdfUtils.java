package com.example.portfolio.service.common.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.OutputStream;

@Component
@Slf4j
public class PdfUtils {

    public void createSampleCvPdf(OutputStream outputStream) {
        log.info("Creating sample CV PDF");
        try{
            Document document = new Document();
            PdfWriter.getInstance(document,outputStream);
            document.open();

            Font nameFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,BaseColor.BLACK);
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 14,BaseColor.DARK_GRAY);
            Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Font textFont = FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.BLACK);

            Paragraph name = new Paragraph("ORHAN TÜRKMENOĞLU",nameFont);
            name.setAlignment(Element.ALIGN_CENTER);
            document.add(name);

            Paragraph title = new Paragraph("Software Engineer | Spring Boot | React", textFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Paragraph contact = new Paragraph("📧 orhan.turkmenoglu@example.com | 🌐 github.com/orhanturkmenoglu", textFont);
            contact.setAlignment(Element.ALIGN_CENTER);
            document.add(contact);

            document.add(Chunk.NEWLINE);

            // 💡 Profil Özeti
            document.add(new Paragraph("Profil Özeti", sectionFont));
            document.add(new Paragraph(
                    "Spring Boot ve React ekosistemlerinde uzmanlaşmış bir yazılım geliştiriciyim. "
                            + "Fintech, e-ticaret ve bulut tabanlı uygulamalarda yüksek performanslı, ölçeklenebilir çözümler geliştiriyorum.",
                    textFont));
            document.add(Chunk.NEWLINE);

            // 🧠 Yetenekler
            document.add(new Paragraph("Yetenekler", sectionFont));
            List skills = new List(List.UNORDERED);
            skills.add(new ListItem("Java, Spring Boot, Spring Security, JPA, Redis"));
            skills.add(new ListItem("React, TypeScript, TailwindCSS"));
            skills.add(new ListItem("AWS (S3, SNS, Secrets Manager)"));
            skills.add(new ListItem("Docker, REST API, JWT, WebSocket"));
            document.add(skills);
            document.add(Chunk.NEWLINE);

            // 💼 Deneyimler
            document.add(new Paragraph("Deneyimler", sectionFont));
            document.add(new Paragraph("Software Engineer - Freelance (2023 - Günümüz)", titleFont));
            document.add(new Paragraph(
                    "- Fintech tabanlı dijital cüzdan ve portföy yönetim sistemleri geliştirdim.\n"
                            + "- Spring Boot ve React tabanlı full-stack çözümler ürettim.\n"
                            + "- AWS servisleriyle güvenli veri yönetimi ve e-posta doğrulama altyapısı kurdum.", textFont));
            document.add(Chunk.NEWLINE);

            // 🚀 Projeler
            document.add(new Paragraph("Projeler", sectionFont));
            document.add(new Paragraph("• FinWallet - Dijital Cüzdan", textFont));
            document.add(new Paragraph("• Portfolio Service - Kişisel Portföy ve PDF Export Sistemi", textFont));
            document.add(new Paragraph("• AfetRadar - Gerçek zamanlı deprem izleme platformu", textFont));
            document.add(Chunk.NEWLINE);

            // 🎓 Eğitim
            document.add(new Paragraph("Eğitim", sectionFont));
            document.add(new Paragraph("Bilgisayar Mühendisliği, X Üniversitesi - 2018-2022", textFont));
            document.add(Chunk.NEWLINE);

            // ✉️ Alt Bilgi
            LineSeparator separator = new LineSeparator();
            separator.setPercentage(100);
            document.add(separator);
            Paragraph footer = new Paragraph("Oluşturulma Tarihi: " + java.time.LocalDate.now(), textFont);
            footer.setAlignment(Element.ALIGN_RIGHT);
            document.add(footer);


            document.close();
            log.info("Sample CV PDF created successfully");
        }catch (DocumentException exception){
            log.error("Error while creating sample CV PDF: {}", exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }
}
