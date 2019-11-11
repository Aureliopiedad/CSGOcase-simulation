package Logup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Logupservlet")
public class Logupservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理注册
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String passwd = request.getParameter("password");
        HttpSession session = request.getSession();
        Logup logup = new Logup(name,passwd);
        long result = LogupDao.logup(logup);
        if(result > 0) {
            Cookie cookie = new Cookie("username", name);
            Cookie cookie1 = new Cookie("userid", Long.toString(result));
            response.addCookie(cookie);
            response.addCookie(cookie1);
            session.setAttribute("userid",result);
            response.sendRedirect("index.jsp");
        }
        else
            response.sendRedirect("index.jsp");

    }
}
