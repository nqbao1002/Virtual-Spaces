function openEditSoundForm(action, soundId, soundName, soundURL) {
    document.getElementById("actionInput").value = action;
    document.getElementById("soundIdInput").value = soundId;
    
    // Kiểm tra và điền dữ liệu tự động nếu mục input không được nhập
    if (action === "update") {
        document.getElementById("soundNameInput").value = soundName || document.getElementById("soundNameInput").value;
        document.getElementById("soundURLInput").value = soundURL || document.getElementById("soundURLInput").value;
    } else {
        document.getElementById("soundNameInput").value = soundName || "";
        document.getElementById("soundURLInput").value = soundURL || "";
    }
    
    document.getElementById("editSoundForm").style.display = "block";
}
function openEditSoundForm(action, soundId, soundName, soundURL) {
    document.getElementById("actionInput").value = action;
    document.getElementById("soundIdInput").value = soundId;
    document.getElementById("soundNameInput").value = soundName;
    document.getElementById("soundURLInput").value = soundURL;
    document.getElementById("editSoundForm").style.display = "block";
}
