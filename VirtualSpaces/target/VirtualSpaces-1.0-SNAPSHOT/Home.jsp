<%-- 
    Document   : Home
    Created on : Feb 27, 2024, 1:55:49 PM
    Author     : a
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Virtual Spaces</title>
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <link rel="stylesheet" href="css/homeCSS.css">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="logo"><img src="img/logo.svg"></div>
                <p id="web-name">Virtual Spaces</p>
                <div class="head-links">
                    <a href="#">About Us</a>
                    <a href="#">Features</a>
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:8080/VirtualSpaces/LoginGoogleHandler&response_type=code&client_id=625652199751-jtmubfjt42j2faun4rsiupv4eekqnum6.apps.googleusercontent.com&approval_prompt=force">Sign Up</a>
                </div>
            </div>

            <div class="body">
                <div class="introduction">
                    <p>Welcome to our online study space revolution! We're here to transform your learning environment and supercharge your productivity. Explore our curated collection of auditory and visual aids to enhance focus and concentration. Plus, track your progress with detailed analytics to maximize your efficiency. Upgrade your study space today and unleash your full potential!</p>
                </div>
                <div class="getstarted-btn">
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:8080/VirtualSpaces/LoginGoogleHandler&response_type=code&client_id=625652199751-jtmubfjt42j2faun4rsiupv4eekqnum6.apps.googleusercontent.com&approval_prompt=force" id="btn-login">Get Started</a>
                </div>
            </div>

            <div class="footer">
                <div class="contact-information" id="email">
                    <i class="fa-solid fa-3x fa-envelope"></i>
                    <p>Email</p>
                    <p>soryzzmikely@gmail.com</p>
                </div>
                <div class="contact-information" id="phone">
                    <i class="fa-solid fa-3x fa-phone"></i>
                    <p>Phone</p>
                    <p>(84-63) 3 836 717 </p>
                </div>
                <div class="contact-information" id="address">
                    <i class="fa-solid fa-3x fa-location-dot"></i>
                    <p>Address</p>
                    <p>FPT University, 9 District, Ho Chi Minh City</p>
                </div>
            </div>
        </div>
    </body>
</html>