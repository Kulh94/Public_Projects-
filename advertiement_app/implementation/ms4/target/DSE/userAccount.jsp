<%@ page import="beans.Advertisement" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: Zhanat
  Date: 15/11/2018
  Time: 21:23
  To change this template use File | Settings | File Templates.
  source: https://www.jquery-az.com/a-free-bootstrap-product-listing-template-with-html-and-css/
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .dot {
            height: 10px;
            width: 10px;
            background-color: #FF0000;
            border-radius: 50%;
            display: inline-block;
        }
    </style>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/stylesheet.css"/>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<nav class="navbar navbar-expand-sm bg-info navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="ShowAllItemsServlet"> All products </a>
    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home </a>
        </li>

        <li style="float:right"
        <% if (session.getAttribute("notify") != null) {%>
        <span class="dot"></span>
        <% } %>
        <a class="nav-link" href="NotificationServlet">Notifications </a>
        </li>

    </ul>
</nav>
<div style="color:red"><p> ${errorEditAdsMess}</p></div>
<div style="color:red"><p> ${NoItemsMessage}</p></div>
<h1 align="center" style="color:Black"><font face="Comic sans MS" size="5">User advertisements</font></h1>

<% ArrayList<Advertisement> userlist = (ArrayList<Advertisement>) request.getAttribute("userList");
    if (userlist != null) {
        for (Advertisement advertisement : userlist) { %>
<div class="container">
    <div class="col-xs-12 col-md-6">
        <!-- First product box start here-->
        <div class="prod-info-main prod-wrap clearfix">
            <div class="row">
                <div class="col-md-5 col-sm-12 col-xs-12">
                    <div class="product-image">
                        <img src="images/products/p4.png" class="img-responsive">
                        <span class="tag2 hot">SPECIAL</span>
                    </div>
                </div>
                <div class="col-md-7 col-sm-12 col-xs-12">
                    <div class="product-deatil">
                        <div>
                            <form action="DeleteAdsServlet" method="post" name="delete" class="form-signin">
                                <input type="hidden" name="Adsid" value="<%=advertisement.getId()%>">
                                <button style="float:right" class="btn btn-danger" name="submit" value="edit"
                                        type="Submit">delete
                                </button>
                            </form>
                        </div>

                        <h5 class="name"><label><b>Titel:</b></label><%=advertisement.getTitle()%> </a>
                            <p class="price-container">
                                <span>Price: <%=advertisement.getPrice()%></span></p>
                            <span class="tag1"></span></h5>
                    </div>
                    <div class="description">
                        <p><%=advertisement.getDescription()%>
                        </p></div>
                    <%
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    %>
                    <div class="description">
                        <p>Publish date: <%=format.format(advertisement.getPublishDate())%>
                        </p></div>
                    <form action="EditAdsServlet" method="post" name="edit" class="form-signin">
                        <input type="hidden" name="Adsid" value="<%=advertisement.getId()%>">
                        <button style="float:right" class="btn btn-danger" name="submit" value="edit" type="Submit">
                            edit
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- end product -->
</div>
<%
        }
    }
%>
</body>
</html>
