<%@ page import="dao.DbSet" %>
<%@ page import="rest.MessageModel" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.MessageDbSet" %>
<%@ page import="rest.UserModel" %><%--
  Created by IntelliJ IDEA.
  User: ravai
  Date: 4/11/2020
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chibi Chat</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://cdn.tiny.cloud/1/in1xb1ct2uhp5kvj8o06zfpuu7rmjdeqhmolche1eszvlhrd/tinymce/5/tinymce.min.js"
            referrerpolicy="origin"></script>
    <style>
        <%@include file="/WEB-INF/stylesheets/welcome.css" %>
    </style>
    <script>
        tinymce.init({
            selector: '#mytextarea',
            plugins: 'a11ychecker advcode casechange formatpainter linkchecker autolink lists checklist media mediaembed pageembed permanentpen powerpaste table advtable tinycomments tinymcespellchecker',
            toolbar: 'a11ycheck addcomment showcomments casechange checklist code formatpainter pageembed permanentpen table',
            toolbar_mode: 'floating',
            tinycomments_mode: 'embedded',
            tinycomments_author: 'Author name',
        });
    </script>
</head>
<body>
<div class="jumbotron text-center">
    <h1>Welcome to ChibiChat</h1>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/ChibiChat_war">ChibiChat</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
            </li>
        </ul>
        <p class="notice"><a href="user.jsp">Register a new nickname</a></p>
        <p class="alert"><a href="chatroom.jsp">Create a new chatroom</a></p>
    </div>
</nav>
<div class="p-2 bd-highlight flex-column ">
    <%
        DbSet dbSet = new DbSet();

        List<MessageModel> messages = dbSet.messageDbSet.GetMultiple((long) session.getAttribute("chatRoomId"));

        for (MessageModel message : messages) {
            UserModel user = dbSet.userDbSet.GetById(message.getUserId());

            String formatString = String.format("<div class=\"container\">\n" +
                    "  <span class=\"time-left\">%s</span><br/>\n" +
                    "  <p>%s</p>\n" +
                    "  <span class=\"time-left\">%s</span>\n" +
                    "</div>\n", user.getNickname(), message.getMessage(), message.getCreatedOn());
            out.write(formatString);
        }
    %>
    <form action="controller.ChatServlet" method="POST">
        <input type="hidden" name="chatRoomId" value="${sessionScope.get("chatRoomId")}" required>
        <input type="hidden" name="userId" value="${sessionScope.get("userId")}" required>
        <label for="message">Message:
            <textarea id="mytextarea" id="message" name="message" required>

                 </textarea> </label>
        <div class="form-group form-control-lg">
            <label>Attachment:
                <input type="file" name="image"> </label>
        </div>
        <br/>
        <div class="form-group form-control-lg">
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Send Message"/>
        </div>
    </form>
</div>

<footer class="page-footer font-small blue"> Copyright: Random Dude
    <div class="footer-copyright text-center py-3">
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
