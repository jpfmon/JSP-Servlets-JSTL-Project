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
    <title>View Car</title>
</head>
<body>
<h1>VIEW CAR</h1>
<hr>
<table>
    <form action="/services" method="get">
        <input type="hidden" name="serviceaction" value="updateThis">
        <input type="hidden" name="serviceId" value="${viewedService.id}">
        <tbody>
        <tr>
            <td>
                Service id:
            </td>
            <td><input type="text" name="serviceId" value="${viewedService.id}"></td>
        </tr>
        <tr>
            <td>
                Name:
            </td>
            <td><input type="text" name="ownerName" value="${viewedService.name}"></td>
        </tr>
        <tr>
            <td>
                Date:
            </td>
            <td><input type="text" name="serviceDate" value="${viewedService.date}"></td>
        </tr>
        <tr>
            <td>
                Car Id:
            </td>
            <td><input type="text" name="carId" value="${viewedService.carId}"></td>
            <td><a href="/cars?carsaction=viewCar&carId=${viewedService.carId}">Go to this car</a></td>
        </tr>
        <tr>
            <td>
                Notes:
            </td>
            <td><input type="text" name="serviceNotes" value="${viewedService.notes}"></td>
        </tr>
        <tr>
            <td>
                Price:
            </td>
            <td><input type="text" name="servicePrice" value="${viewedService.price}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
    </form>
    <td>
        <button onclick="location.href = '/services';">Cancel</button>
    </td>
    </tr>
    </tbody>
</table>
<form action="/services" method="get"
      onsubmit="return confirm('Do you really want to delete this car and its services?');">
    <input type="hidden" name="serviceaction" value="deleteThis">
    <input type="hidden" name="serviceId" value="${viewedService.id}">
    <input type="submit" value="Delete Service" style="color:red;"/>
</form>
</body>
</html>
