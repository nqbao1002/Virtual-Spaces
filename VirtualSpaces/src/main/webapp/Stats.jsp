<%-- 
    Document   : Stats
    Created on : Mar 13, 2024, 9:09:48 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/taglist.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='/css/statsCSS.css' />" rel="stylesheet" type="text/css" media="all"/>
        <title>Stats</title>
    </head>
    <body style="background-color: black">
        <div class="stats">
            <div class="header-stats">
                <h1 style="margin-left: 150px;">Your stats</h1>
                <div class="back">
                    <h1 style="cursor: pointer">X</h1>
                </div>
            </div>
            <div class="body-stats">
                <div class="streak">
                    <h5>Longest streak</h5>
                    <h5 style="margin-top: 7px;">${sessionScope.days} Days</h5>
                </div>
                <div class="vertical-line"></div>
                <div class="hours"> 
                    <h5>Hours on web</h5>
                    <h5 style="margin-top: 7px;">${sessionScope.formattedHours} Hours</h5>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="<c:url value='/javascript/statsJS.js'/>"></script>
    </body>
</html>
