<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<%@include file="WEB-INF/fragments/head.jsp" %>
<body>
<%@include file="WEB-INF/fragments/navbar.jsp" %>
<div class="d-flex bd-highlight">

    <div class="p-2 w-100 bd-highlight">
        <c:forEach var="message" items="${sessionScope.messageList}">
            <div class="container">
                <span class="time-left">${message.sendername}</span><br/>
                <p>${message.message}</p>
                <span class="time-left">${message.createdOn}</span>
            </div>
        </c:forEach>

        <form action="controller.ChatServlet" method="POST">
            <label for="message">Message:
                <textarea class="form-control" id="mytextarea" id="message" name="message" required>
                 </textarea> </label>
            <br/>
            <div class="form-group form-control-lg">
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Send Message"/>
            </div>
        </form>
    </div>
    <div class="p-2 flex-shrink-1 bd-highlight">
        <code>
            <label>Name:</label>
            ${sessionScope.get("chatroomname")}
            <label>Category:</label>
            ${sessionScope.get("chatroomcategory")}
            <br/>
            <label>Rules:</label>  <br/>
            ${sessionScope.get("chatroomrules")}
            <br/>
        </code>
    </div>
</div>

<%@include file="WEB-INF/fragments/tail.jsp" %>

</body>
</html>
