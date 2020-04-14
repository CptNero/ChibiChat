<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="WEB-INF/fragments/head.jsp" %>
<body>
<%@include file="WEB-INF/fragments/navbar.jsp" %>
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

<%@include file="WEB-INF/fragments/tail.jsp" %>

</body>
</html>
