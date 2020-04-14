<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="rest.ChatRoomModel" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DbSet" %>
<!DOCTYPE HTML>
<html>
<%@include file="WEB-INF/fragments/head.jsp" %>
<body>
<%@include file="WEB-INF/fragments/navbar.jsp" %>


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
                    <c:forEach var="chatroom" items="${applicationScope.chatrooms}">
                        <option value="${chatroom.id}">${chatroom.name}</option>
                    </c:forEach>
                </select>
            </label>
        </div>
        <br/>
        <div class="form-group form-control-lg">
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Join Chat"/>
        </div>
    </form>
</div>

<%@include file="WEB-INF/fragments/tail.jsp" %>

</body>
</html>
