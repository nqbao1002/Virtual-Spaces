$(document).ready(function () {
    $('.option-direction').hide();
    $('#fortune-inner').hide();
    $('.model').hide();
    $('#audio-container').draggable();
    $('#audio-container').hide();

    $('.fortune-dragging').draggable();

    $('#openModel').click(function () {
        $('.model').show();
        console.log("Clicked");
    });

    $('#closeModel').click(function () {
        $('.model').hide();
    });

    $('#openFortune').click(function () {
        $('#fortune-inner').show();
    });

    $('#closeFortune').click(function () {
        $('#fortune-inner').hide();
    });

    $('#open-audio').click(function () {
        console.log("hahahaha");
        $('#audio-container').show();
    });

    $('#close-audio').click(function () {
        $('#audio-container').hide();
    });


});




//------------------------------------------------------------------------------

let player;
let videoList = [];
let currentIndex = 0;

function onYouTubeIframeAPIReady() {
    player = new YT.Player('player', {
        height: '360',
        width: '640',
        videoId: 'gnMajPQgkiA', // ID video mặc định
        playerVars: {
            'autoplay': 1,
            'loop': 1,
            'rel': 0,
            'fs': 0,
            'controls': 0,
            'disablekb': 1,
            'mute': 1
        },
        events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
        }
    });
}

function onPlayerReady(event) {
    event.target.playVideo();
}

function onPlayerStateChange(event) {
    if (event.data == YT.PlayerState.ENDED) {
        nextVideo();
    }
}

function loadVideos(type) {
    console.log("Loading videos for type:", type);
    $.ajax({
        type: "GET",
        url: "/VirtualSpaces/loadvideos",
        data: {type: type},
        dataType: 'json',
        success: function (response) {
            videoList = response;
            currentIndex = 0;
            console.log("Video list loaded:", videoList);
            if (videoList.length > 0) {
                displayVideo();
            }
            showButtons(type);
        },
        error: function (error) {
            console.log("Error loading videos:", error);
        }
    });
}

function displayVideo() {
    if (videoList.length > 0 && videoList[currentIndex]) {
        console.log("Playing video:", videoList[currentIndex].videoURL);
        player.loadVideoById(videoList[currentIndex].videoURL);
    } else {
        console.log("No videos available or invalid index");
    }
}

function nextVideo() {
    if (currentIndex < videoList.length - 1) {
        currentIndex++;
    } else {
        currentIndex = 0;
    }
    displayVideo();
}

function prevVideo() {
    if (currentIndex > 0) {
        currentIndex--;
    } else {
        currentIndex = videoList.length - 1;
    }
    displayVideo();
}
function toggleSound(audioId) {
    console.log(audioId);
    var audio = document.getElementById(audioId);
    var volumeSlider = document.querySelector(`input[id^=volume${audioId.slice(-1)}]`);
    var playButton = document.getElementById(`play-${audioId}`);

    if (audio.volume === 0) {
        audio.volume = 0.5;
        audio.play();
        audio.loop = true;
        playButton.innerHTML = '<i id="play-street-icon" class="fa-solid fa-2x fa-volume-high"></i>';
        volumeSlider.value = 50;
    } else {
        audio.volume = 0;
        audio.pause();
        playButton.innerHTML = '<i id="play-street-icon" class="fa-solid fa-2x fa-volume-xmark"></i>';
        volumeSlider.value = 0;
    }
}

function changeVolume(audioId, value) {
    var audio = document.getElementById(audioId);
    var playButton = document.getElementById(`play-${audioId}`);

    if (value > 0) {
        audio.volume = value / 100;
        audio.play();
        audio.loop = true;
        playButton.innerHTML = '<i id="play-street-icon" class="fa-solid fa-2x fa-volume-high"></i>';
    } else {
        audio.volume = 0;
        audio.pause();
        playButton.innerHTML = '<i id="play-street-icon" class="fa-solid fa-2x fa-volume-xmark"></i>';
    }
}

// Gọi hàm này khi trang tải xong để hiển thị video đầu tiên
window.onload = function () {
    // Kiểm tra nếu danh sách video không rỗng trước khi hiển thị
    if (videoList.length > 0) {
        displayVideo();
    }
};
//------------------------------------------------------------------------------
function openTasksInNewTab() {
    var url = "./TaskController?action=task";
    var win = window.open(url, '_blank');
    win.focus();
}

