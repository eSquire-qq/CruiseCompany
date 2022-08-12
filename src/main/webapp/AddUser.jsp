<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.cruisecompany.dao.UserDAO" %>
<%@page import="com.example.cruisecompany.entity.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<form action="<%= request.getContextPath() %>/AddNewUser" method="post">
    <div class="container">
        <h1>User Register</h1>
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
