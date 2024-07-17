$(document).ready(function () {
    $('.stats').hide();
    $(document).ready(function () {
        $("#stat-button").click(function () {
            $(".stats").show();
            $('.stats').draggable();
        });
        $(".back h1").click(function () {
            $(".stats").hide();
        });
    });
});