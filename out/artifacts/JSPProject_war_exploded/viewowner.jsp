<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Juan
  Date: 28/05/2020
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Owner Form</title>
</head>
<body>
<h1>DETAILS OF OWNER: <c:out value="${viewOwner.id}"/></h1>
<hr>
<table>
    <form action="owners" method="get">
        <input type="hidden" name="ownersaction" value="updateThis">
        <input type="hidden" name="ownerId" value="${viewOwner.id}">
        <tbody>
        <tr>
            <td>
                Full Name:
            </td>
            <td><input type="text" name="fullName" value="${viewOwner.fullName}"></td>
        </tr>
        <tr>
            <td>
                Id Card Number:
            </td>
            <td><input type="text" name="idCard" value="${viewOwner.idCardNumber}"></td>
        </tr>
        <tr>
            <td>
                Phone Number:
            </td>
            <td><input type="text" name="phoneNumber" value="${viewOwner.phone}"></td>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td><input type="email" name="email" value="${viewOwner.email}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save Edits"></td>
    </form>
    <td>
        <button onclick="location.href = '/owners';">Cancel</button>
    </td>
    </tr>
    </tbody>
</table>
<form action="owners" method="get"
      onsubmit="return confirm('Do you really want to delete this owner and all Cars and Services associated to it?');">
    <input type="hidden" name="ownersaction" value="deleteThis">
    <input type="hidden" name="ownerId" value="${viewOwner.id}">
    <input type="submit" value="Delete Owner" style="color:red;"/>
</form>
<hr>
<div>
    <div>
        <h3>Cars Owned</h3>
        <table>
            <thead>
            <tr>
                <td>Car id</td>
                <td>Car brand</td>
                <td>Car model</td>
                <td>Services</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cartemp" items="${carsList}">

                <tr>
                <td>${cartemp.id}</td>
                <td>${cartemp.brand}</td>
                <td>${cartemp.model}</td>
                <c:forEach var="servtemp" items="${servicesList}">
                    <c:if test="${servtemp.carId == cartemp.id}">
                        <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>${servtemp.id} | ${servtemp.name} | ${servtemp.date} | ${servtemp.price} | ${servtemp.notes}</td>
                    </c:if>
                </c:forEach>
                </tr>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%--    <div>--%>
<%--        <h3>Services</h3>--%>
<%--        <table>--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <td>Service id</td>--%>
<%--                <td>Service name</td>--%>
<%--                <td>Service date</td>--%>
<%--                <td>Car id</td>--%>
<%--                <td>Notes</td>--%>
<%--                <td>Price</td>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <c:forEach var="servicetemp" items="${servicesList}">--%>
<%--                <tr>--%>
<%--                    <td>${servicetemp.id}</td>--%>
<%--                    <td>${servicetemp.name}</td>--%>
<%--                    <td>${servicetemp.date}</td>--%>
<%--                    <td>${servicetemp.carId}</td>--%>
<%--                    <td>${servicetemp.notes}</td>--%>
<%--                    <td>${servicetemp.price}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
</html>
