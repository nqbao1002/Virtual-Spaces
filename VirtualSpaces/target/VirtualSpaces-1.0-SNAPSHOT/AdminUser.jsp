<%-- 
    Document   : AdminUser
    Created on : Mar 19, 2024, 2:23:22 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='/css/adminSound.css' />" rel="stylesheet" type="text/css" media="all"/>
        <title>Admin User</title>
    </head>
    <body>
        <div class="adminFortune">
            <div class="adminHome"><%@include file="AdminHome.jsp" %></div>
            <div class="adminFortune-body">
                <table border="1">
                    <thead>
                        <tr>
                            <td>NO.</td>
                            <td>ID</td>
                            <td>User Name</td>
                            <td>Email</td>
                            <td>Days</td>
                            <td>Hour</td>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.listUser}" var="user" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.userStats.getDays()}</td>
                            <td>${user.userStats.getHours()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
