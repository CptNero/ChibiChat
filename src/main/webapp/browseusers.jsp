<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="WEB-INF/fragments/head.jsp" %>
<body>

<div class="p-2 bd-highlight flex-column">
    <%@include file="WEB-INF/fragments/navbar.jsp" %>

    <form action="controller.BrowseUsersServlet" method="POST">
        <div class="form-group form-control-lg">
            <label for="name"> Search by Name
                <input class="form-control" type="text" id="name" name="name"> </label>
        </div>
        <div class="form-group form-control-lg">
            <label for="interest"> Search by Interest
                <input class="form-control" type="text" id="interest" name="interest"> </label>
        </div>
        <br/>
        <div class="form-group form-control-lg">
            <input class="btn btn-sm btn-primary" type="submit" value="Search">
        </div>
    </form>

    <table class="table">
        <tr>
            <th>NickName</th>
            <th>Age</th>
            <th>Sex</th>
            <th>Interests</th>
        </tr>
        <c:forEach var="user" items="${applicationScope.usersBrowse}">
            <tr>
                <td>${user.nickname}</td>
                <td>${user.age}</td>
                <c:choose>
                    <c:when test="${user.sex == 'true'}">
                        <td>Male</td>
                    </c:when>
                    <c:when test="${user.sex == 'false'}">
                        <td>Female</td>
                    </c:when>
                </c:choose>
                <td>${user.interests}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="WEB-INF/fragments/tail.jsp" %>
</body>
</html>
