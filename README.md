# JSP Servlet Currency Converter

Dự án Maven Webapp chuyển đổi USD sang VNĐ, tương thích Jakarta Servlet / Tomcat 10.1+.

## Cấu trúc

- `pom.xml`
- `src/main/java/com/codegym/ConverterServlet.java`
- `src/main/webapp/index.jsp`
- `src/main/webapp/WEB-INF/web.xml`

## Chạy dự án

1. Cài JDK 17+ và Maven.
2. Mở terminal tại thư mục dự án.
3. Chạy:

```bash
mvn clean package
```

4. File WAR được tạo tại:

`target/jsp-servlet-currency-converter.war`

5. Deploy WAR lên Tomcat 10.1+.
6. Mở:

`http://localhost:8080/jsp-servlet-currency-converter/`
