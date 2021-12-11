<%--
  Created by IntelliJ IDEA.
  User: xiaohu
  Date: 2021/12/7
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${map.msg}<br/>
<form action="login" method="post">
  帐号：<input type="text" name="username"><br>
  密码：<input type="password" name="password"><br>
  <input type="submit" value="确定">
</form>
</body>
</html>
