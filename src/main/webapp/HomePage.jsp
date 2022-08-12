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
