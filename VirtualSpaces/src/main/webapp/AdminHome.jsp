<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Virtual Spaces</title>
        <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js' />"></script>
        <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'/>"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
        <link href="css/adminCSS.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <div class="nav-bar">
                <div class="admin-profile">
                    <img src=${sessionScope.user.picture} alt="admin-avatar"/>
                </div>
                <hr>
                <ul class="list-functions">
                    <form action="./AdminUserController" method="post">
                        <li>
                            <button id="open-user-user" class="option-button" name="action" value="user"><i 
                                    class="fa-solid fa-users"></i><br>Users</button>
                        </li>
                    </form>
                    <li>
                        <button id="open-edit-video" class="option-button"><i
                                class="fa-solid fa-circle-play"></i><br>Spaces</button>
                    </li>
                    <form action="./AdminSoundController" method="post">
                        <li>
                            <button id="open-edit-sound" class="option-button" name="action" value="sound"><i
                                    class="fa-solid fa-headphones"></i><br>Sounds</button>
                        </li>
                    </form>
                    <form action="./AdminFortuneController" method="post">
                        <li>
                            <button id="open-edit-fortune" class="option-button" name="action" value="fortune"><i
                                    class="fa-solid fa-hand-sparkles"></i><br>Fortunes</button>
                        </li>
                    </form>
                    <form action="UserHome.jsp">
                        <li>
                            <button class="option-button">
                                <i class="fa-solid fa-house"></i><br>User Home
                            </button>
                        </li>
                    </form>
                </ul>
            </div>
        </div>
        <script type="text/javascript" src="<c:url value='/javascript/adminJS.js' />"></script>
    </body>
</html>
