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
    <title>New Car Form</title>
</head>
<body>
<h1>PLEASE, INTRODUCE DETAILS OF NEW CAR</h1>
<hr>
<table>
    <form action="owners" method="get">
        <input type="hidden" name="ownersaction" value="addthis">
        <tbody>
        <tr>
            <td>
                Full Name:
            </td>
            <td><input type="text" name="fullName"></td>
        </tr>
        <tr>
            <td>
                Id Card Number:
            </td>
            <td><input type="text" name="idCard"></td>
        </tr>
        <tr>
            <td>
                Phone Number:
            </td>
            <td><input type="text" name="phoneNumber"></td>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
    </form>
    <td>
        <button onclick="location.href = '/owners';">Cancel</button>
    </td>
    </tr>
    </tbody>

</table>
</body>
</html>
