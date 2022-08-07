<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<form action="<%= request.getContextPath() %>/HomePage.jsp" method="post">
    <div class="container">
        Home page
    </div>

    <div>
        <a class="AddUser.jsp" href="#">  </a>
        <p>Don't have an account yet?<a href="AddUser.jsp">Create new account</a>.</p>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="LoginUser.jsp">Sign in</a>.</p>
    </div>

</form>
</body>
</html>
