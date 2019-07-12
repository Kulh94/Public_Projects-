<%@ page import="beans.Advertisement" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Zhanat
  Date: 13/11/2018
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<!-- source : https://www.w3schools.com/bootstrap/bootstrap_navbar.asp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Advertisment Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        .form-control-borderless {
            border: none;
        }

        .form-control-borderless:hover, .form-control-borderless:active, .form-control-borderless:focus {
            border: none;
            outline: none;
            box-shadow: none;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-info navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="ShowAllItemsServlet"> All products </a>

    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="LoginServlet">Log in </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="RegistrationServlet">Register </a>
        </li>
        <li class="nav-item">
            <% if (session.getAttribute("id") != null) {%>
            <a class="nav-link" href="AddAdsServlet">Add Product to sell </a>
        </li>
        <% } %>
        <li class="nav-item">
            <% if (session.getAttribute("id") != null) {%>
            <a class="nav-link" href="ShowUserAds"> my account </a>
        </li>
        <% } %>
        <% if (session.getAttribute("id") != null) {%>
        <li class="nav-item">
            <a class="nav-link" href="LogoutServlet"> logout </a>
        </li>
        <% } %>
    </ul>
</nav>
<div style="color:red"><p> ${okMessage}</p></div>
<div style="color:red"><p> ${notLoggetMess}</p></div>
<div style="color:red"><p> ${itemAdded}</p></div>
<div style="color:red"><p> ${loggedInMess}</p></div>
<div style="color:red"><p> ${alreadyloggedMess}</p></div>
<div style="color:red"><p> ${signInMess}</p></div>
<div style="color:red"><p> ${loggedOutdMess}</p></div>
<div style="color:red"><p> ${editAdsMessage}</p></div>
<div style="color:red"><p> ${deleteMess}</p></div>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
      integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<div class="container">
    <br/>
    <div class="row justify-content-center">
        <div class="col-12 col-md-10 col-lg-8">

            <form class="card card-sm" method="post" name="Search" action="SearchByKeyword">
                <div class="card-body row no-gutters align-items-center">
                    <div class="col-auto">
                        <i class="fas fa-search h4 text-body"></i>
                    </div>
                    <!--end of col-->
                    <div class="col">
                        <input class="form-control form-control-lg form-control-borderless" type="search" name="keyword"
                               placeholder="Search item by keyword" required>
                    </div>
                    <!--end of col-->
                    <div class="col-auto">
                        <button class="btn btn-lg btn-success" type="submit">Search</button>
                    </div>
                    <!--end of col-->
                </div>
            </form>
        </div>
        <!--end of col-->
    </div>
</div>
</body>
</html>