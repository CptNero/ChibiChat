<%--
  Created by IntelliJ IDEA.
  User: ravai
  Date: 4/10/2020
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chibi Chat</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/stylesheets/welcome.css" %>
    </style>
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

<div class="p-2 bd-highlight flex-column">


    <form action="controller.ChatRoomServlet" method="POST">
        <div class="form-group form-control-lg">
            <label for="name">Name:
                <input class="form-control" type="text" id="name" name="name" required> </label>
        </div>
        <div class="form-group form-control-lg">
            <label for="category">Category:
                <input class="form-control" type="text" id="category" name="category" required/> </label>
        </div>
        <div class="form-group form-control-lg">
            <label for="rules">Rules:
                <input class="form-control" type="text" id="rules" name="rules" required/> </label>
        </div>
        <br/>
        <div class="form-group form-control-lg">
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Create Chat Room"/>
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
