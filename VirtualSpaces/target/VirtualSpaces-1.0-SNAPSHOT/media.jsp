<%-- 
    Document   : media.jsp
    Created on : Mar 6, 2024, 12:34:13 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglist.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link href="<c:url value='/css/mediaCSS.css' />" rel="stylesheet" type="text/css" media="all"/>
        <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js' />"></script>
        <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'/>"></script>
        
    </head>
    <body>
        <div class="task1">
            <div class="header1">
                <h4 style="margin-top: -58px;">Media</h4>
                <p>_</p>
            </div>
            <hr style="margin-top: -58px;">

            <div class="media">
                <iframe style="border-radius:12px"
                        src="https://open.spotify.com/embed/playlist/3WaPIctfucmoAp1BaERDnd?utm_source=generator" width="100%"
                        height="352" frameBorder="0" allowfullscreen=""
                        allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
                        loading="lazy">

                </iframe>
            </div>
            <form id="media" action="./MediaController" method="post">
                <div class="body-URL">
                    <div class="URL">
                        <input type="url" name="url" placeholder="Enter Youtube link">
                    </div>
                    <input id="submit-media" style="cursor: pointer" class="Save" type="submit" value="Save">
                </div>
            </form>

        </div>
        <script type="text/javascript" src="<c:url value='/javascript/mediaJS.js'/>"></script>
    </body>
</html>
