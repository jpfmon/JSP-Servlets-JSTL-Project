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
    <form action="/cars" method="get">
        <input type="hidden" name="carsaction" value="updateThis">
        <input type="hidden" name="carId" value="${viewedCar.id}">
        <tbody>
        <tr>
            <td>
                Car id:
            </td>
            <td><input type="text" name="carId" value="${viewedCar.id}"></td>
        </tr>
        <tr>
            <td>
                Owner:
            </td>
            <td><input type="text" name="ownerId" value="${viewedCar.owner_id}"></td>
            <td><a href="/owners?ownersaction=viewOwner&ownerId=${viewedCar.owner_id}">Go to this owner</a></td>
        </tr>
        <tr>
            <td>
                Brand:
            </td>
            <td><input type="text" name="brand" value="${viewedCar.brand}"></td>
        </tr>
        <tr>
            <td>
                Model:
            </td>
            <td><input type="text" name="model" value="${viewedCar.model}"></td>
        </tr>
        <tr>
            <td>
                Plate Number:
            </td>
            <td><input type="text" name="plate" required></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
    </form>
    <td>
        <button onclick="location.href = '/cars';">Cancel</button>
    </td>
    </tr>
    </tbody>
</table>
<form action="/cars" method="get"
      onsubmit="return confirm('Do you really want to delete this car and its services?');">
    <input type="hidden" name="carsaction" value="deleteThis">
    <input type="hidden" name="carId" value="${viewedCar.id}">
    <input type="submit" value="Delete Car" style="color:red;"/>
</form>
</body>
</html>
