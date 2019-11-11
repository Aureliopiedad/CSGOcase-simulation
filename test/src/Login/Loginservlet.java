package Login;
import PT.History;
import PT.HistoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet
public class Loginservlet extends HttpServlet {
    public Loginservlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理登录
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String passwd = request.getParameter("password");

        Login login = new Login(name, passwd);
        long result = LoginDao.login(login);
        if (result > 0) {
            String history = HistoryDao.getHistory(new History(result));
            Cookie cookie2 = new Cookie("history",history);

            Cookie cookie = new Cookie("username", name);
            Cookie cookie1 = new Cookie("userid", Long.toString(result));
            response.addCookie(cookie);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            session.setAttribute("userid",result);
        }

        response.sendRedirect("index.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}
