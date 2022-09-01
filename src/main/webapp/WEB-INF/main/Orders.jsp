<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.cruisecompany.entity.Cruise" %>
<%@ page import="com.example.cruisecompany.dao.UserCruiseDAO" %>
<%@ page import="com.example.cruisecompany.entity.User" %>
<%@ page import="com.example.cruisecompany.entity.UserCruise" %>
<%@ page import="java.util.List" %>
<% Cruise cruise = (Cruise) session.getAttribute("cruise"); %>

<% User user = (User) session.getAttribute("user"); %>

<%
    UserCruiseDAO userCruiseDao = UserCruiseDAO.getUserCruiseInstance();
    List<UserCruise> userOrders  = userCruiseDao.showOrderForAdmin();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Catalog</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand">Cruise company</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="AdminHomePage">Home</a></li>
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="AdminCatalog">Catalog</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page Header-->
<header class="masthead" style="background-image: url('assets/img/Orders-bg.jpg')">
    <div class="container position-relative px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-7">
                <div class="site-heading">
                    <h1>Orders</h1>
                    <span class="subheading"></span>
                </div>
            </div>
        </div>
    </div>
</header>

<%
    if (!userOrders.isEmpty()){
        for (UserCruise order : userOrders){
%>
<div class="container px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
        <div class="col-md-10 col-lg-8 col-xl-7">
            <!-- Post preview-->
            <div class="post-preview">
                <a>
                    <h3 class="post-subtitle"><strong>User id:</strong><%=order.getUserId()%></h3>
                    <h3 class="post-subtitle"><strong>Cabin number:</strong><%=order.getCabinNumber()%> </h3>
                    <h3 class="post-subtitle"><strong>Ticket number:</strong> <%=order.getTicketId()%></h3>
                    <h3 class="post-subtitle"><strong>Phone number: </strong><%=order.getStatusId()%> </h3>
                    <h3 class="post-subtitle"><strong>Cruise number:</strong> <%=order.getCruiseId()%></h3>
                    <a href="RemoveBooking?ticketId=<%=order.getTicketId()%>" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;">Remove</a>
                    <a href="ConfirmOrder?id=<%=order.getTicketId()%>" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;">Confirm</a>
                </a>
            </div>
            <hr class="my-4" />
        </div>
    </div>
</div>
<%
        }
    }
%>

<footer class="border-top">
    <div class="container px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-7">
                <ul class="list-inline text-center">
                    <li class="list-inline-item">
                        <a href="https://www.facebook.com/profile.php?id=100047603651889">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                                    </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://twitter.com/eSquire_11">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                                    </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://github.com/eSquire-qq">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                                    </span>
                        </a>
                    </li>
                </ul>
                <div class="small text-center text-muted fst-italic">NLC &copy; Cruises 2022</div>
            </div>
        </div>
    </div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
