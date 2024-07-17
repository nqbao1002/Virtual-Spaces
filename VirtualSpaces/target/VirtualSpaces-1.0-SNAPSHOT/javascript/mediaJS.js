$(document).ready(function () {
    $(".task1").draggable();

    $(document).ready(function () {
        $(".body-media").hide();
        $("#media-button").click(function () {
            // Ẩn task-2 và hiện task
            $(".body-media").show();
        });
        $(".header1 p").click(function () {
            // Ẩn task-2 và hiện task
            $(".body-media").hide();
        });
    });

    // Lắng nghe sự kiện submit của form
    $("#media").submit(function (event) {
        event.preventDefault(); // Ngăn chặn việc gửi form

        // Lấy giá trị URL từ input
        var youtubeUrl = $('input[name="url"]').val();

        // Kiểm tra xem URL có hợp lệ không (ở đây chỉ kiểm tra đơn giản)
        if (isValidYoutubeUrl(youtubeUrl)) {
            // Lấy mã nhúng video từ URL YouTube
            var embedCode = getEmbedCodeFromYoutubeUrl(youtubeUrl);

            // Thay đổi mã nhúng của thẻ iframe
            $('.media').html(embedCode);
        } else {
            alert('Invalid YouTube URL!');
        }
    });

    // Hàm kiểm tra tính hợp lệ của URL YouTube
    function isValidYoutubeUrl(url) {
        // Sử dụng biểu thức chính quy để kiểm tra
        var pattern = /^(http(s)?:\/\/)?((w){3}.)?youtu(be|.be)?(\.com)?\/.+/;
        return pattern.test(url);
    }

    // Hàm lấy mã nhúng video từ URL YouTube
    function getEmbedCodeFromYoutubeUrl(url) {
        // Lấy id video từ URL YouTube
        var youtubeId = extractYoutubeId(url);

        // Tạo mã nhúng video từ id
        var embedCode = '<iframe style="border-radius:12px" src="https://www.youtube.com/embed/' + youtubeId + '" width="100%" height="352" frameborder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture" loading="lazy"></iframe>';
        return embedCode;
    }

    // Hàm trích xuất id video từ URL YouTube
    function extractYoutubeId(url) {
        // Biểu thức chính quy để trích xuất id video
        var pattern = /(?:youtube\.com\/(?:[^\/\n\s]+\/\S+\/|(?:v|e(?:mbed)?)\/|\S*?[?&]v=)|youtu\.be\/)([a-zA-Z0-9_-]{11})/;
        var match = url.match(pattern);
        return match && match[1];
    }

    $("#submit-media").click(function () {
        // Lấy dữ liệu từ form
        var formData = $("#media").serialize();

        // Gửi dữ liệu đến servlet MediaController
        $.post("./MediaController", formData, function (response) {
            
        });
    });
});