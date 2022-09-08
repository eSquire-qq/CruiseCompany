<%--suppress ALL --%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cruisecompany.dao.CruiseDAO" %>
<%@ page import="com.example.cruisecompany.servlets.Catalog" %>
<%@ page import="com.example.cruisecompany.entity.Cruise" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<%
    CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();
    List<Cruise> cruises = cruiseDAO.readAll();
%>

<!DOCTYPE html>
<html language = "${param.lang}">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Catalog of cruises</title>
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
        <a class="navbar-brand"><fmt:message key="label.header1"/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="AdminHomePage"><fmt:message key="label.home"/></a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page Header-->
<header class="masthead" style="background-image: url('assets/img/catalog-bg.jpg')">
    <div class="container position-relative px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-7">
                <div class="site-heading">
                    <h1><fmt:message key="label.catalog"/></h1>
                    <span class="subheading"><fmt:message key="label.subtitle"/></span>
                </div>
            </div>
        </div>
    </div>
</header>

<%
    if (!cruises.isEmpty()){
        for (Cruise cruise : cruises){
%>
<!-- Main Content-->
<div class="container px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
        <div class="col-md-10 col-lg-8 col-xl-7">
            <!-- Post preview-->
            <div class="post-preview">
                <a>
                    <h2 class="post-title"><%= cruise.getCruiseName()%></h2>
                    <h3 class="post-subtitle"><strong><fmt:message key="label.departure"/>:</strong> <%= cruise.getDeparture()%></h3>
                    <h3 class="post-subtitle"><strong><fmt:message key="label.destination"/>:</strong> <%= cruise.getDestination()%></h3>
                    <h3 class="post-subtitle"><strong><fmt:message key="label.date"/>:</strong> <%= cruise.getCruiseStartDate()%> - <%= cruise.getCruiseEndDate()%></h3>
                    <a href="Information?id=<%= cruise.getId()%>" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;"><fmt:message key="label.button"/></a>
                    <a href="UpdateCruise?id=<%=cruise.getId()%>" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;"><fmt:message key="label.change"/></a>
                    <a href="DeleteCruise?id=<%=cruise.getId()%>" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;"><fmt:message key="label.delete"/></a>
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
<!-- Footer-->
<footer class="border-top">
    <div class="container px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-7">
                <ul class="list-inline text-center">
                    <li class="list-inline-item">
                        <a href="https://twitter.com/eSquire_11">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                                    </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://www.facebook.com/profile.php?id=100047603651889">
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