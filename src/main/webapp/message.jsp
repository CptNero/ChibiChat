<%--
  Created by IntelliJ IDEA.
  User: ravai
  Date: 4/11/2020
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/stylesheets/welcome.css"%></style>
</head>
<body>
<form action = "controller.UserServlet" method = "POST">
    <input type="hidden" name="chatRoomId">
    <input type = "hidden" name = "userId">
    <br />
    <label>Message:
        <input type = "text" name = "message"> </label>
    <br />
    <label>Image
        <input type = "number" name = "image" /> </label>
    <br />
    <input type = "submit" value = "Send Message" />
</form>
</body>
</html>
