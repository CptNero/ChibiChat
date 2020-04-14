<%@ page import="dao.ChatRoomDbSet" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.UserDbSet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="WEB-INF/fragments/head.jsp" %>
<body>
<%@include file="WEB-INF/fragments/navbar.jsp" %>

<div class="p-2 bd-highlight flex-column ">
    <form action="controller.UserServlet" method="POST">
        <div class="form-group form-control-lg">
            <label for="nickname">Nickname:
                <input class="form-control" type="text" id="nickname" name="nickName" required> </label>
        </div>
        <div class="form-group form-control-lg">
            <label for="age">Age:
                <input class="form-control" type="number" id="age" name="age" required/> </label>
        </div>
        <div class="form-group form-control-lg">
            <label for="sex">Sex:
                <select class="form-control" id="sex" name="sex" required>
                    <option value = "0">Male</option>
                    <option value = "1">Female</option>
                </select> </label>
        </div>
        <div class="form-group form-control-lg">
            <label for="interests">Interests:
                <input class="form-control" type="text" id="interests" name="interests" required/> </label>
        </div>
        <br/>
        <div class="form-group form-control-lg">
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Register User"/>
        </div>
    </form>
</div>

<%@include file="WEB-INF/fragments/tail.jsp" %>

</body>
</html>
