<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var = 'logged' value = "${sessionScope.login}"/>
<c:if test="${logged != true}">
    <c:redirect url="/login"/>
</c:if>
<head>
    <title>Services Dashboard</title>
</head>
<body>
<h1>Here you can find all the services listed</h1>

<form action="/dashboard">
    <input type="submit" value="Main Dashboard"/>
</form>
</body>
</html>
