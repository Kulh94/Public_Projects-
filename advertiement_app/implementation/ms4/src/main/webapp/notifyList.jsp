<%@ page import="beans.Advertisement" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Zhanat
  Date: 06/01/2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

    </ul>
</nav>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
      integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<h1 align="center" style="color:Black"><font face="Comic sans MS" size="5">New advertisements matching your last search
    criteria</font></h1>
<% ArrayList<Advertisement> userlist = (ArrayList<Advertisement>) request.getAttribute("userList");

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
                </div>
            </div>
        </div>
        <!-- end product -->
    </div>
</div>
<%}%>
</body>
</html>

