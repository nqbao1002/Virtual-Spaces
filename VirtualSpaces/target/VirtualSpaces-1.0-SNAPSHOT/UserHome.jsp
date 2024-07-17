<%@page import="com.virtualspaces.model.VideoType"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%-- 
    Document   : UserHome
    Created on : Feb 27, 2024, 1:56:01 PM
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <title>Virtual Spaces</title>
        <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js' />"></script>
        <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'/>"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
        <link href="css/userCSS.css" rel="stylesheet" />
    </head>

    <body>
        <div class="container">
            <div class="sidebar">
                <div class="head">
                    <div class="user-img">
                        <img src=${sessionScope.user.picture}
                             alt="user image" />
                    </div>                    
                </div>

                <div class="nav">
                    <div class="menu">
                        <ul class="list-functions">
                            <li>
                                <button id="openModel" class="option-button"><i class="fa-solid fa-mountain-city"></i><br>Spaces</button>
                            </li>
                            <li>
                                <button id="open-audio" class="option-button"><i class="fa-solid fa-headphones"></i><br>Sounds</button>
                            </li>
                            <li>
                                <button id="show-tasks-button" class="option-button" onclick="openTasksInNewTab()">
                                    <i class="fa-solid fa-list-check"></i><br>Tasks
                                </button>
                            </li>
                            <li>
                                <button id="openFortune" class="option-button"><i class="fa-solid fa-hand-sparkles"></i><br>Fortunes</button>
                            </li>
                            <li>
                                <button id="media-button" class="option-button"><i class="fa-solid fa-circle-play"></i><br>Media</button>
                            </li>
                            <li>
                                <button id="stat-button" class="option-button"><i class="fa-solid fa-fire"></i><br>Stats</button>
                            </li>
                            <li>
                                <button onclick="window.location.href = '/VirtualSpaces/LogoutController'" class="option-button">
                                    <i class="fa-solid fa-arrow-right-from-bracket"></i><br>Logout
                                </button>
                            </li>
                        </ul>
                    </div>
                </div>


                <div class="body-media">
                    <%@include file="media.jsp" %>
                </div>

                <div class="stats-1">
                    <%@include file="Stats.jsp" %>
                </div>

                <div class="model" id="model">
                    <div class="model-inner">
                        <div class="type-list">
                            <c:forEach items="${sessionScope.typelist}" var="i">
                                <div class="type" style="background-image: url(${i.getTypeIMG()});  background-size: 100% 100%; background-repeat: no-repeat; background-position: center;">
                                    <div class="type-name">
                                        <p onclick="loadVideos('${i.getTypeName()}')">${i.getTypeName()}</p>
                                    </div>
                                    <div class="option-direction ${i.getTypeName()}-direction">
                                        <button class="video-option-button" onclick="prevVideo()">
                                            <i class="fa-solid fa-arrow-left"></i>
                                        </button>
                                        <button class="video-option-button" onclick="nextVideo()">
                                            <i class="fa-solid fa-arrow-right"></i>
                                        </button>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <button id="closeModel">Close</button>
                </div>
            </div>
        </div>


        <div class="height-100 bg-light">     
            <div id="player"></div>
        </div>

        <div id="fortune-inner" class="fortune-dragging">
            <div class="fortune-title">
                <p>Daily Fortune</p>
                <button id="closeFortune"><i class="fa-solid fa-minus"></i></button>
            </div>
            <div id="fortune-content">
                <p>${fortune.getFortuneContent()}</p>
            </div>
        </div>

        <div id="audio-container">
            <div class="audio-header">
                <p>Soundboard</p>
                <button id="close-audio">
                    <i class="fa-solid fa-minus"></i>
                </button>
            </div>
            <c:forEach items="${sessionScope.soundlist}" var="a">
                <div class="audio-item">
                    <div class="sound-title">
                        <p>${a.getSoundName()}</p>
                    </div>
                    <button class="play-button" id="play-${a.getSoundName()}" onclick="toggleSound('${a.getSoundName()}')">
                        <i id="play-${a.getSoundName()}-icon" class="fa-solid fa-2x fa-volume-xmark"></i>
                    </button>
                    <audio loop preload="auto" id="${a.getSoundName()}" src="${a.getSoundURL()}"></audio>
                    <input type="range" class="volume-slider" id="volume${a.getSoundName()}" value="0"
                           oninput="changeVolume('${a.getSoundName()}', this.value)">
                </div>
            </c:forEach>
        </div>





        <script>
            var videoList = [];
        </script>
        <script src="https://www.youtube.com/iframe_api"></script>
        <script src="javascript/userJS.js"></script>


    </body>

</html>
