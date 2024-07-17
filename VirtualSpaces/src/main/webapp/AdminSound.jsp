<%-- 
    Document   : AdminSound
    Created on : Mar 18, 2024, 7:47:21 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='/css/adminSound.css' />" rel="stylesheet" type="text/css" media="all"/>
        <title>Admin Sound</title>
    </head>
    <body>
        <script>
            function validateAddSoundForm() {
                var soundName = document.getElementById("soundNameInput").value.trim();
                var soundURL = document.getElementById("soundURLInput").value.trim();

                if (soundName === "" || soundURL === "") {
                    alert("Please fill in all fields.");
                    return false; // Ngăn chặn form submit nếu có trường input trống
                }
                return true; // Cho phép form submit nếu tất cả các trường input được điền đầy đủ
            }
        </script>
        <div class="adminFortune">
            <div class="adminHome"><%@include file="AdminHome.jsp" %></div>
            <div class="adminFortune-body">
                <div id="editSoundForm" style="display: none;">
                    <form action="./AdminSoundController" method="post" onsubmit="return validateAddSoundForm();">
                        <input type="hidden" name="soundId" value="" id="soundIdInput" />
                        Sound Name: <input type="text" name="soundName" id="soundNameInput" />
                        Sound URL: <input type="text" name="soundURL" id="soundURLInput" />
                        <input type="hidden" name="action" id="actionInput" />
                        <input type="submit" value="Save" id="submitSoundForm" />
                    </form>
                </div>
                <table border="1">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Sound Name</td>
                            <td>Sound URL</td>
                            <td>Update</td>
                            <td>Delete</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.listSound}" var="sound">
                            <tr>
                                <td>${sound.soundId}</td>
                                <td>${sound.soundName}</td>
                                <td>${sound.soundURL}</td>
                                <td>
                                    <button onclick="openEditSoundForm('update', '${sound.soundId}', '${sound.soundName}', '${sound.soundURL}')">Update</button>
                                </td>
                                <td>
                                    <form action="./AdminSoundController" method="post">
                                        <input type="hidden" name="soundId" value="${sound.soundId}" />
                                        <input type="hidden" name="action" value="delete" />
                                        <input type="submit" value="Delete" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button onclick="openEditSoundForm('add', '', '', '')">Add Sound</button>

            </div>
        </div>

        <script type="text/javascript" src="<c:url value='/javascript/AdminSoundJS.js'/>"></script>
    </body>
</html>
