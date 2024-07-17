function openEditFortuneForm(action, fortuneId, fortuneContent) {
    document.getElementById("actionInput").value = action;
    if (action === "update") {
        document.getElementById("fortuneIdInput").value = fortuneId;
        document.getElementById("fortuneContentInput").value = fortuneContent;
    } else {
        document.getElementById("fortuneIdInput").value = "";
        document.getElementById("fortuneContentInput").value = "";
    }
    document.getElementById("editFortuneForm").style.display = "block";
}
