<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglist.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link href="<c:url value='/css/taskCSS.css' />" rel="stylesheet" type="text/css" media="all"/>
        <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js' />"></script>
        <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'/>"></script>
        <title>Task page</title>
    </head>
    <body>
        <div class="task">
            <div class="task-1">
                <button class="add-btn" onclick="openEditTaskForm('add', '', '', '', '', '')">Add Task</button>
                <c:forEach items="${sessionScope.listTask}" var="task">
                    <table>
                        <tr>
                            <td>Task Name</td>
                        </tr>
                        <tr>
                            <td><a href="TaskController?action=detail&taskId=${task.taskID}">${task.taskName}</a></td>
                            <td>
                                <form action="./TaskController" method="post">
                                    <input type="hidden" name="action" value="delete" />
                                    <input type="hidden" name="taskId" value="${task.taskID}" />
                                    <input type="submit" value="X" />
                                </form>
                            </td>
                        </tr>
                    </table>
                </c:forEach>
            </div>
            <div class="task-2" id="task-detail">
                <form id="task-detail-form" action="./TaskController" method="post">
                    <input type="hidden" name="taskId" value="${task.taskID}" />
                    Task Description<br>
                    <input type="text" name="taskDescription" value="${task.taskDescription}" /><br>
                    Date<br>
                    <input type="date"  name="date" value="${fn:substringBefore(task.date, ' ')}" /><br>
                    Time Start<br>
                    <input type="time"  name="timeStart" value="${fn:substring(task.timeStart, 11, 16)}" /><br>
                    Time End<br>
                    <input type="time" name="timeEnd" value="${fn:substring(task.timeEnd, 11, 16)}" /><br>
                    <input type="hidden" id="actionInput" name="action" value="" />
                    <input type="submit" value="Save" />
                </form>
            </div>

            <script>
                document.querySelectorAll('#task-detail-form input').forEach(input => {
                    input.addEventListener('input', () => {
                        document.getElementById('actionInput').value = 'update';
                    });
                });
            </script>   
            <div id="editTaskForm" style="display: none;">
                <form action="./TaskController" method="post" onsubmit="return validateAddTaskForm();">
                    <input type="hidden" name="taskID" value="" id="taskIDInput" />
                    Task Name: <br><input style="width: 100%;" type="text" name="taskName" id="taskNameInput" />
                    <br>
                    Task Description: <br><input style="width: 100%;" type="text" name="taskDescription" id="taskDescriptionInput" /><br>
                    Date: <input type="date" name="date" id="dateInput" />
                    Time Start: <input type="time" name="timeStart" id="timeStartInput" />
                    Time End: <input type="time" name="timeEnd" id="timeEndInput" />
                    <input type="hidden" name="action" id="actionInput" value="add" />
                    <input type="submit" value="Save" id="submitTaskForm" />
                </form>
            </div>

        </div>


        <script type="text/javascript" src="<c:url value='/javascript/taskJS.js' />"></script>
    </body>
</html>
