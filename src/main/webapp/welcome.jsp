<%@ page import="rest.ChatRoomModel" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DbSet" %>
<!DOCTYPE HTML>
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

    <form action="controller.WelcomeServlet" method="POST">
        <p>Login, if you've already registered a nickname</p>
        <div class="form-group form-control-lg">
            <label for="nickname">Nickname:
                <input class="form-control" type="text" id="nickname" name="nickname" required> </label>
        </div>
        <div class="form-group form-control-lg">
            <label>Select a chat room:
                <select class="form-control" name="chatroom">
                    <%
                        DbSet dbSet = new DbSet();
                        List<ChatRoomModel> chatRooms = dbSet.chatRoomDbSet.List();

                        for (ChatRoomModel chatRoom : chatRooms) {
                            String formatString = String.format("<option value=\"%d\">%s</option>\n", chatRoom.getId(), chatRoom.getName());
                            out.write(formatString);
                        }
                    %>
                </select>
            </label>
        </div>
        <br/>
        <div class="form-group form-control-lg">
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Join Chat"/>
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
