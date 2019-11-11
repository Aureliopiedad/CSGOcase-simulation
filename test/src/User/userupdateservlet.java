package User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "userupdateservlet")
public class userupdateservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String passwd = request.getParameter("password");
        String passwd2 = request.getParameter("password2");
        int isvip = Integer.parseInt(request.getParameter("vip"));
        boolean ret=(isvip==1)?true:false;
        HttpSession session = request.getSession();


        if (passwd.equals(passwd2)) {
            long id = Long.valueOf(String.valueOf(session.getAttribute("userid"))).longValue();
            userupdate up = new userupdate(id, name, passwd, ret);
            int result = userupdateDao.userupdate(up);
            if(result > 0) {
                Cookie cookie = new Cookie("username", name);
                response.addCookie(cookie);
                cookie.setMaxAge(30);
                response.sendRedirect("index.jsp");
            }
            else {
                response.sendRedirect("loginsuccess.jsp");
            }
        }
        else
            response.sendRedirect("loginsuccess.jsp");
    }
}
