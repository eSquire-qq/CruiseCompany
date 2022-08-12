<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.cruisecompany.dao.AdminDAO" %>
<%@page import="com.example.cruisecompany.entity.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin registration</title>

    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="bootstrap-gird.css">
    <link rel="stylesheet" href="bootstrap-reboot.css">

    <link rel="stylesheet" href="bootstrap.bundle.js">
    <link rel="stylesheet" href="bootstrap.js">
</head>
<body>
<form action="<%= request.getContextPath() %>/AddNewAdmin" method="post">
    <div class="container">
        <h1>Admin register</h1>
        <p>Please fill in this form to create an account.</p>

        <label for="name" id="fn">First Name:</label>
        <input type="text" name="name" id="name"><br/>

        <label  for="surname" id="ln">Last Name:</label>
        <input type="text" name="surname" id="surname"><br/>

        <label  for="password" id="pwd">Password:</label>
        <input type="password" name="password" id="password"><br/>

        <label  for="phoneNumber" id="mn">Mobile number:</label>
        <input type="text" name="phoneNumber" id="phoneNumber"><br/>

        <label  for="email" id="em">Email:</label>
        <input type="text" name="email" id="email"><br/>

    </div>

    <div class="container signin">
        <p>Already have an account? <a href="LoginUser.jsp">Sign in</a>.</p>
    </div>

    <button type="submit" value="Submit" id="button">Register</button>
    <a href="HomePage.jsp">Back to Home</a>

</form>
</body>
</html>