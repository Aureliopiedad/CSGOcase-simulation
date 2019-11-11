package User;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Logoutservlet")
public class Logoutservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        Cookie cookie = new Cookie("username", null);
        Cookie cookie1 = new Cookie("userid", null);
        Cookie cookie2 = new Cookie("product",null);
        Cookie cookie3 = new Cookie("count",null);
        Cookie cookie4 = new Cookie("history",null);
        cookie.setMaxAge(0);
        cookie1.setMaxAge(0);
        cookie2.setMaxAge(0);
        cookie3.setMaxAge(0);
        cookie4.setMaxAge(0);
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addCookie(cookie4);
        response.sendRedirect("index.jsp");
    }
}
