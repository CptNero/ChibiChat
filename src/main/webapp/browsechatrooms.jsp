<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ravai
  Date: 4/14/2020
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="WEB-INF/fragments/head.jsp" %>
<body>
<div class="p-2 bd-highlight flex-column">
    <div class="p-2 bd-highlight flex-column">
        <%@include file="WEB-INF/fragments/navbar.jsp" %>

        <form action="controller.BrowseChatRoomsServlet" method="POST">
            <div class="form-group form-control-lg">
                <label for="name"> Search by Name
                    <input class="form-control" type="text" id="name" name="name"> </label>
            </div>
            <div class="form-group form-control-lg">
                <label for="category"> Search by Category
                    <input class="form-control" type="text" id="category" name="category"> </label>
            </div>
            <br/>
            <div class="form-group form-control-lg">
                <input class="btn btn-sm btn-primary" type="submit" value="Search">
            </div>
        </form>

        <table class="table">
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Rules</th>
            </tr>
            <c:forEach var="chatroom" items="${applicationScope.chatRoomsBrowse}">
                <tr>
                    <td>${chatroom.name}</td>
                    <td>${chatroom.category}</td>
                    <td>${chatroom.rules}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
    <%@include file="WEB-INF/fragments/tail.jsp" %>
</body>
</html>
