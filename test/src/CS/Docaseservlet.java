package CS;

import PT.History;
import PT.HistoryDao;
import PT.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Docaseervlet")
public class Docaseservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        int csid = Integer.parseInt(request.getParameter("casenum"));
        long userid = Long.valueOf(String.valueOf(session.getAttribute("userid"))).longValue();
        Docase dc = new Docase(userid,csid);
        List<Product> productList = CSDao.CSDao(dc);
        Product finalproduct = null;
        if(null != productList && !productList.isEmpty()){
            Double result = Math.random();
            for(Product product : productList){
                if(result >= product.getProbability()){
                    result -= product.getProbability();
                }
                else{
                    finalproduct = product;
                    HistoryDao.addHistory(new History(userid,csid,finalproduct.getPTID()));
                    Cookie cookie = new Cookie("product",finalproduct.toString());
                    Cookie cookie2 = new Cookie("count",Integer.toString(dc.getCount()));
                    Cookie cookie3 = new Cookie("history",HistoryDao.getHistory(new History(userid)));
                    response.addCookie(cookie);
                    response.addCookie(cookie2);
                    response.addCookie(cookie3);
                    break;
                }
            }
        }
        response.sendRedirect("index.jsp");
    }
}
