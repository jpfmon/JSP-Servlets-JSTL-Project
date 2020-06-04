<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Juan
  Date: 21/05/2020
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<c:set var='logged' value="${sessionScope.login}"/>
<c:if test="${logged != true}">
    <c:redirect url="/login"/>
</c:if>

<head>
    <title>Car Management Dashboard</title>
    <style>
        .header{
            border-width: 1px;
            border-style: solid;
            border-color: green;
            text-align: center;
        }
        .container {
            border-width: 2px;
            border-style: solid;
            border-color: red;
            display: flex;
        }

        .box {
            border-width: 2px;
            border-style: solid;
            border-color: black;
            flex: 1; /* additionally, equal width */
            padding: 1em;
            border: solid;
            text-align: center;
        }

        .listsBox{
            border-width: 2px;
            border-style: solid;
            border-color: violet;
            margin: auto;
            text-align: center;
            display: flex;
        }

        .lists{
            flex: 1; /* additionally, equal width */
            padding: 1em;
            border: solid;
            color: orange;
            text-align: center;
        }
        .head{
            color: black;
        }
    </style>
</head>
<body>
<%--Estas log in?: ${sessionScope.login}--%>
<div class="header">
    <h1> Welcome to your Car Management Dashboard</h1>
</div>
<hr>

<div class="container">
    <div class="box">
        <h3><a href="/owners">Manage Owners</a></h3><br><br>
        <div class="listsBox">
            <table class="lists">
                <thead class="head">
                <tr>
                    <td>Owner id</td>
                    <td>Owner fullname</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ownertemp" items="${ownerslist}">
                    <tr>
                        <td>${ownertemp.id}</td>
                        <td>${ownertemp.fullName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="box">
        <h3><a href="cars">Manage Cars</a></h3><br><br>
        <div class="listsBox">
        <table class="lists">
            <thead class="head">
            <tr>
                <td>Car id</td>
                <td>Owner id</td>
                <td>Car brand</td>
                <td>Car model</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cartemp" items="${carslist}">
                <tr>
                    <td>${cartemp.id}</td>
                    <td>${cartemp.owner_id}</td>
                    <td>${cartemp.brand}</td>
                    <td>${cartemp.model}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
    <div class="box">
        <h3><a href="services.jsp">Manage Services</a></h3><br><br>
        <div class="listsBox">
            <table class="lists">
                <thead class="head">
                <tr>
                    <td>Service id</td>
                    <td>Service name</td>
                    <td>Service date</td>
                    <td>Car id</td>
                    <td>Notes</td>
                    <td>Price</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="servicetemp" items="${serviceslist}">
                    <tr>
                        <td>${servicetemp.id}</td>
                        <td>${servicetemp.name}</td>
                        <td>${servicetemp.date}</td>
                        <td>${servicetemp.carId}</td>
                        <td>${servicetemp.notes}</td>
                        <td>${servicetemp.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<br>
<hr>
<form action="/logout">
    <input type="submit" value="Log Out"/>
</form>
</body>
</html>
