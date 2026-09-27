package com.codegym;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet(name = "ConverterServlet", urlPatterns = {"/convert"})
public class ConverterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            double rate = Double.parseDouble(request.getParameter("rate"));
            double usd = Double.parseDouble(request.getParameter("usd"));
            double vnd = rate * usd;

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang='vi'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("<title>Kết quả chuyển đổi</title>");
                out.println("<style>");
                out.println("body{font-family:Arial,sans-serif;background:#f8fafc;display:flex;justify-content:center;align-items:center;min-height:100vh;margin:0}");
                out.println(".card{background:#fff;width:420px;padding:32px;border-radius:14px;box-shadow:0 8px 28px rgba(0,0,0,.12);text-align:center}");
                out.println("h2{color:#1b2a7a;margin-top:0}");
                out.println(".line{margin:12px 0;font-size:17px;color:#333}");
                out.println(".total{font-size:24px;font-weight:700;color:#27ae60;margin:20px 0}");
                out.println("a{display:inline-block;text-decoration:none;background:#1b2a7a;color:#fff;padding:11px 18px;border-radius:8px}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='card'>");
                out.println("<h2>KẾT QUẢ CHUYỂN ĐỔI</h2>");
                out.printf(Locale.US, "<div class='line'>Tỉ giá: <b>%,.2f VND/USD</b></div>%n", rate);
                out.printf(Locale.US, "<div class='line'>Số tiền USD: <b>$%,.2f</b></div>%n", usd);
                out.printf(Locale.US, "<div class='total'>Thành tiền VNĐ: %,.2f VNĐ</div>%n", vnd);
                out.println("<a href='index.jsp'>Quay lại</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (NumberFormatException | NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang='vi'><head><meta charset='UTF-8'><title>Lỗi</title>");
                out.println("<style>body{font-family:Arial,sans-serif;text-align:center;margin-top:100px}.error{color:#c0392b}</style>");
                out.println("</head><body>");
                out.println("<h2 class='error'>Lỗi: Vui lòng nhập số hợp lệ!</h2>");
                out.println("<a href='index.jsp'>Quay lại</a>");
                out.println("</body></html>");
            }
        }
    }
}
