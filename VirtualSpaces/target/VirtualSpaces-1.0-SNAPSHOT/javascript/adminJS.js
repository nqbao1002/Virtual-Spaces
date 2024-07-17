$(document).ready(function () {

    $(".close-model").click(function () {
        $(".edit-model").css('visibility', 'hidden');
        $(".video-edit-model-options").css('visibility', 'hidden');
        $(".sound-edit-model-options").css('visibility', 'hidden');
        $(".fortune-edit-model-options").css('visibility', 'hidden');
    });

    $("#open-edit-video").click(function () {
        $(".edit-model").css('visibility', 'hidden');
        $(".video-edit-model-options").css('visibility', 'hidden');
        $(".sound-edit-model-options").css('visibility', 'hidden');
        $(".fortune-edit-model-options").css('visibility', 'hidden');
        $("#video-edit").css('visibility', 'visible');
    });

    $("#open-edit-sound").click(function () {
        $(".edit-model").css('visibility', 'hidden');
        $(".video-edit-model-options").css('visibility', 'hidden');
        $(".sound-edit-model-options").css('visibility', 'hidden');
        $(".fortune-edit-model-options").css('visibility', 'hidden');
        $("#sound-edit").css('visibility', 'visible');
    });

    $("#open-edit-fortune").click(function () {
        $(".edit-model").css('visibility', 'hidden');
        $(".video-edit-model-options").css('visibility', 'hidden');
        $(".sound-edit-model-options").css('visibility', 'hidden');
        $(".fortune-edit-model-options").css('visibility', 'hidden');
        $("#fortune-edit").css('visibility', 'visible');
    });
    //-------------------------------------------------------------//
    $("#open-edit-video-add").click(function () {
        $(".video-edit-model-options").css('visibility', 'hidden');
        $("#video-edit-model-add").css('visibility', 'visible');
    });

    $("#open-edit-video-delete").click(function () {
        $(".video-edit-model-options").css('visibility', 'hidden');
        $("#video-edit-model-delete").css('visibility', 'visible');
    });

    $("#open-edit-video-update").click(function () {
        $(".video-edit-model-options").css('visibility', 'hidden');
        $("#video-edit-model-update").css('visibility', 'visible');
    });
    //------------------------------------------------------------//
    $("#open-edit-sound-add").click(function () {
        $(".sound-edit-model-options").css('visibility', 'hidden');
        $("#sound-edit-model-add").css('visibility', 'visible');
    });

    $("#open-edit-sound-delete").click(function () {
        $(".sound-edit-model-options").css('visibility', 'hidden');
        $("#sound-edit-model-delete").css('visibility', 'visible');
    });

    $("#open-edit-sound-update").click(function () {
        $(".sound-edit-model-options").css('visibility', 'hidden');
        $("#sound-edit-model-update").css('visibility', 'visible');
    });
    //------------------------------------------------------------//
    $("#open-edit-fortune-add").click(function () {
        $(".fortune-edit-model-options").css('visibility', 'hidden');
        $("#fortune-edit-model-add").css('visibility', 'visible');
    });

    $("#open-edit-fortune-delete").click(function () {
        $(".fortune-edit-model-options").css('visibility', 'hidden');
        $("#fortune-edit-model-delete").css('visibility', 'visible');
    });

    $("#open-edit-fortune-update").click(function () {
        $(".fortune-edit-model-options").css('visibility', 'hidden');
        $("#fortune-edit-model-update").css('visibility', 'visible');
    });
    $.ajax({
        type: "POST",
        url: "AdminSoundController", // URL của servlet hoặc controller xử lý yêu cầu
        data: {
            action: "delete",
            soundId: soundIdToDelete // id của âm thanh cần xóa
        },
        success: function (response) {
            // Chuyển hướng đến trang UserHome.jsp sau khi xóa thành công
            window.location.href = "UserHome.jsp";
        },
        error: function (xhr, status, error) {
            console.error("Error deleting sound: " + error);
        }
    });



});