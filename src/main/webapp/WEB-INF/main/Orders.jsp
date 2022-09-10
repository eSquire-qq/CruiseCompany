<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.cruisecompany.entity.Cruise" %>
<%@ page import="com.example.cruisecompany.dao.UserCruiseDAO" %>
<%@ page import="com.example.cruisecompany.entity.User" %>
<%@ page import="com.example.cruisecompany.entity.UserCruise" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<% Cruise cruise = (Cruise) session.getAttribute("cruise"); %>

<% User user = (User) session.getAttribute("user"); %>

<%
    UserCruiseDAO userCruiseDao = UserCruiseDAO.getUserCruiseInstance();
    List<UserCruise> userOrders  = userCruiseDao.showOrderForAdmin();
%>

<!DOCTYPE html>
<html language = "${param.lang}">
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
<%
    if(session.getAttribute("language") != null){
%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<%
}else{
%>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="language"/>
<%
    }
%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand"><fmt:message key="label.header"/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="AdminHomePage"><fmt:message key="label.home"/></a></li>
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="AdminCatalog"><fmt:message key="label.catalog"/></a></li>
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
                    <h1><fmt:message key="label.titleADMINOrder"/></h1>
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
                    <h3 class="post-subtitle"><strong><fmt:message key="label.userIDADMINOrder"/>:</strong><%=order.getUserId()%></h3>
                    <h3 class="post-subtitle"><strong><fmt:message key="label.cabinNumberADMINOrder"/>:</strong><%=order.getCabinNumber()%> </h3>
                    <h3 class="post-subtitle"><strong><fmt:message key="label.ticketNumberADMINOrder"/>:</strong> <%=order.getTicketId()%></h3>
                    <h3 class="post-subtitle"><strong><fmt:message key="label.ticketStatusADMINOrder"/>: </strong><%=order.getStatusId()%> </h3>
                    <h3 class="post-subtitle"><strong><fmt:message key="label.cruiseNumber"/>:</strong> <%=order.getCruiseId()%></h3>
                    <img class="card-img-top" src="documents/<%=order.getDocument()%>" style="width: auto; height: 163px" alt="Card image cap">
                    <c:if test="<%=order.getStatusId() != 0 %>">
                        <a href="#" class="btn btn-primary disabled" style="background-color: #448b85; border-color: #448b85;"><fmt:message key="label.confirm"/></a>
                        <a href="#" class="btn btn-primary disabled" style="background-color: #448b85; border-color: #448b85;"><fmt:message key="label.refute"/></a>
                    </c:if>

                    <c:if test="<%=order.getStatusId() == 0%>">
                        <a href="ConfirmOrder?id=<%=order.getTicketId()%>" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;"><fmt:message key="label.confirm"/></a>
                        <a href="RefuteOrder?id=<%=order.getTicketId()%>" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;"><fmt:message key="label.refute"/></a>
                    </c:if>
                    <a href="RemoveBooking?ticketId=<%=order.getTicketId()%>" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;"><fmt:message key="label.remove"/></a>
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
