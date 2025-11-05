# Portfolio Service

**Portfolio Service**, geliştiricinin kişisel portfolyosunu yönetmek için tasarlanmış modern bir Spring Boot REST API’dir. Bu servis ile `About`, `Work Experience`, `Projects` ve `Skills` gibi portfolyo bölümleri kolayca yönetilebilir.  

Amacı, frontend uygulamalarıyla (React, Angular, Vue vs.) hızlıca entegre edilebilecek bir backend çözümü sunmaktır.

---

## 🚀 Özellikler

- **CRUD Operasyonları**: About, Work Experience, Projects ve Skills bölümleri için.
- **MongoDB ile Veri Yönetimi**: Esnek ve hızlı veri işlemleri.
- **Global Exception Handling**: Hatalar tek formatta, anlaşılır bir şekilde döner.
- **Swagger/OpenAPI Desteği**: API’yi görselleştirme ve test etme imkânı.
- **CORS Desteği**: Frontend uygulamalar için hazır.
- **BaseResponse Yapısı**: Tüm API cevapları standart bir formatta döner.

---

## 🛠️ Kullanılan Teknolojiler

- Java 17+
- Spring Boot 3.x
- Spring Data MongoDB
- Lombok
- Jakarta Validation (Bean Validation)
- Springdoc OpenAPI (Swagger)
- Maven

---

## ⚡ Başlarken

### Ön Koşullar

- Java 17 veya üzeri
- Maven 3.9 veya üzeri
- MongoDB (varsayılan: `mongodb://localhost:27017/portfolio`)

### Kurulum

1. Repository’yi klonlayın:
```bash
git clone https://github.com/orhanturkmenoglu/portfolio-service.git
cd portfolio-service