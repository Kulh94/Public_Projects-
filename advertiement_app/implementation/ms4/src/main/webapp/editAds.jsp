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
    <title><title>Edit an advertisement</title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>

    </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-info navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="ShowAllItemsServlet"> All products </a>

    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home </a>
        </li>
    </ul>
</nav>
<br>
<div style="color:red"><p> ${errorEditAdsMess}</p></div>
<h1 align="center" style="color:Black"><font face="Comic sans MS" size="5">Edit here your advertisement</font></h1>
<form method="post" action="ResaveAdsServlet">
    <div class="container">
        <label> <b>Tietl</b></label><br>
        <input type="text" name="title" id="title" value="${ads.title}"><br><br>
        <label><b>Price</b></label><br>
        <input type="text" name="price" id="price" value="${ads.price}"><br><br>
        <label><b>Description</b></label><br>
        <textarea type="text" rows="4" cols="50" name="description" id="theInput">${ads.description}</textarea> <br><br>
        <label><b>E-mail</b></label><br>
        <input type="text" name="email" id="email" value="${ads.email}"><br><br>
        <input type="hidden" name="adsId" id="adsId" value="${ads.id}"><br>
        <input type="submit" class="button button1" value="edit"/>
    </div>
</form>

</body>
</html>
