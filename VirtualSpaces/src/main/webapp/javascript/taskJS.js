function openEditTaskForm(action, taskName, taskDescription, date, timeStart, timeEnd) {
    document.getElementById("actionInput").value = action;
    document.getElementById("taskNameInput").value = taskName;
    document.getElementById("taskDescriptionInput").value = taskDescription;
    document.getElementById("dateInput").value = date;
    document.getElementById("timeStartInput").value = timeStart;
    document.getElementById("timeEndInput").value = timeEnd;

    // Kiểm tra nếu action là "add" thì hiển thị div "editTaskForm"
    if (action === "add") {
        document.getElementById("task-detail").style.display = "none";
        document.getElementById("editTaskForm").style.display = "block";
    }
}
