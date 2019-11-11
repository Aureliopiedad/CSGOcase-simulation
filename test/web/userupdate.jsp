<%--
  Created by IntelliJ IDEA.
  User: Aurelito
  Date: 2019/11/4
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userupdate</title>
</head>
<body>
    <form action="userupdateservlet" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        重复密码：<input type="password" name="password2"><br>
        是否成为会员：
        <select name="vip">
            <option value="1">是</option>
            <option value="0">否</option>
        </select><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
