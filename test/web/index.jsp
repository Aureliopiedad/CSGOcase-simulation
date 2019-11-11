<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%!
        public int func1(String string){
            int index = 0;
            int count = 0;
            String findstr = "<br>";
            while((index = string.indexOf(findstr,index)) != -1){
                index += findstr.length();
                count++;
            }
            return count;
        }
  %>
  <%
      Cookie[] cookies = request.getCookies();
      String username="";
      String product = "";
      String history = "";
      int count = 0;
      long id = -1;
      if(cookies != null){
        for(Cookie cookie : cookies){
          if(cookie.getName().equals("username")){
            username = cookie.getValue();
          }
          if(cookie.getName().equals("userid")){
              id = Long.parseLong(cookie.getValue());
          }
          if(cookie.getName().equals("count")){
              count = Integer.parseInt(cookie.getValue());
          }
          if(cookie.getName().equals("product")){
              product = cookie.getValue();
          }
          if(cookie.getName().equals("history")){
              history = cookie.getValue();
          }
        }
      }
      if(("").equals(username) || id == -1){
  %>
  点击按钮登录。
  <form action="login.jsp" method="post">
    <input type="submit" value="登录">
  </form>
  点击按钮注册。
  <form action="logup.jsp" method="post">
    <input type="submit" value="注册">
  </form>
  <%
      }
      else{
  %>
  欢迎：<%="uid > "+id + "<br>username >" + username%>
  登录成功。
  <form action="userupdate.jsp" method="post">
      请求修改：
      <input type="submit" value="修改">
  </form>
  <form action="Logoutservlet" method="post">
      注销：
      <input type="submit" value="注销">
  </form>
  <form action="Docaseservlet" method="post">
          开箱：
      <select name="casenum">
        <option value="1">case1</option>
      </select>
      <input type="submit" value="开箱">
  </form>
  结果：<%=product%><br>

  开箱历史：<br><%=history%>
  <%
      }
  %>

  </body>
</html>
