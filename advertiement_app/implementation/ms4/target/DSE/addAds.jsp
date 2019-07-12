<%--
  Created by IntelliJ IDEA.
  User: Zhanat
  Date: 05/01/2019
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
            <a class="nav-link" href="index.jsp">Log out </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="ShowUserAds"> my account </a>
        </li>
    </ul>
</nav>
<br>
<h1 align="center" style="color:Black"><font face="Comic sans MS" size="5">add here a product to sell</font></h1>
<div style="color:red"><p> ${errorMessage}</p></div>
<div style="color:red"><p> ${successMessage}</p></div>
<form method="post" action="AddAdsServlet">
    <div class="container">
        <label><b>Titel</b></label><br>

        <input type="text" placeholder="Enter titel" name="titel" required><br>

        <label><b>Price</b></label><br>

        <input type="text" placeholder="Enter  price" name="price" required><br>

        <label><b>Description</b></label><br>

        <textarea type="text" placeholder="Enter description" name="desc" required></textarea><br>

        <label><b>E-mail</b></label><br>

        <input type="text" placeholder="Enter e-mail" name="email" required><br>

        <input type="submit" class="button button1" value="Add"/>
    </div>
</form>

</body>
</html>
