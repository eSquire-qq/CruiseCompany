<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.cruisecompany.dao.UserLoginDAO.*"%>
<%@page import="com.example.cruisecompany.entity.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<form action="<%= request.getContextPath() %>/LoginUser" method="post">
    <div class="container">
        <h1>Log in </h1>
        <p>Please fill in this form to log in your account</p>

        <label  for="phoneNumber" id="mn">Mobile number:</label>
        <input type="text" name="phoneNumber" id="phoneNumber"><br/>

        <label  for="password" id="pwd">Password:</label>
        <input type="password" name="password" id="password"><br/>

    </div>

    <div>
        <a class="AddUser.jsp" href="#">  </a>

        <p>Don't have an account yet?<a href="AddUser.jsp">Create new account</a>.</p>
    </div>

    <button type="submit" value="Submit" id="button">Submit</button>
    <a href="HomePage.jsp">Back to Home</a>

</form>
</body>
</html>