<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.cruisecompany.dao.UserLoginDAO.*"%>
<%@page import="com.example.cruisecompany.entity.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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

    <button type="submit" value="Submit" id="button">Submit</button>

    <div>
        <a class="AddUser.jsp" href="#">  </a>

        <p>Don't have an account yet?<a href="AddUser.jsp">Create new account</a>.</p>
    </div>

    <a href="HomePage.jsp">Back to Home</a>

</form>
</body>
</html>