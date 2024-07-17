<%-- 
    Document   : AdminFortune
    Created on : Mar 18, 2024, 5:39:22 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='/css/adminFortune.css' />" rel="stylesheet" type="text/css" media="all"/>
        <title>Admin Fortune</title>
    </head>
    <body>
        <script>
            function validateAddFortuneForm() {
                var fortuneContent = document.getElementById("fortuneContentInput").value.trim();

                if (fortuneContent === "") {
                    alert("Please fill in the Fortune Content field.");
                    return false; // Ngăn chặn form submit nếu trường input trống
                }
                return true; // Cho phép form submit nếu trường input được điền đầy đủ
            }
        </script>
        <div class="adminFortune">
            <div class="adminHome"><%@include file="AdminHome.jsp" %></div>
            <div class="adminFortune-body">
                <div id="editFortuneForm" style="display: none;">
                    <form action="./AdminFortuneController" method="post" onsubmit="return validateAddFortuneForm();">
                        <input type="hidden" name="fortuneId" value="" id="fortuneIdInput" />
                        Fortune Content: <input style="width: 40%;"t type="text" name="fortuneContent" id="fortuneContentInput" />
                        <input type="hidden" name="action" id="actionInput" />
                        <input type="submit" value="Save" id="submitFortuneForm" />
                    </form>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fortune Content</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.listFortune}" var="fortune">
                            <tr>
                                <td>${fortune.fortuneID}</td>
                                <td>${fortune.fortuneContent}</td>
                                <td>
                                    <button class="update-btn" onclick="openEditFortuneForm('update', '${fortune.fortuneID}', '${fortune.fortuneContent}')">Update</button>
                                </td>
                                <td>
                                    <form action="./AdminFortuneController" method="post">
                                        <input type="hidden" name="fortuneId" value="${fortune.fortuneID}" />
                                        <input type="hidden" name="action" value="delete" />
                                        <input class="delete-btn" type="submit" value="Delete" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button class="add-btn" onclick="openEditFortuneForm('add', '', '')">Add Fortune</button>
            </div>
        </div>

        <script type="text/javascript" src="<c:url value='/javascript/AdminFortuneJS.js'/>"></script>
    </body>
</html>
