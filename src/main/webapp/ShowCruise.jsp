<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/ShowCruise" method="post">

    <label for="id" id="idi">Id</label>
    <input type="text" name="id" id="id"><br/>

    <button type="submit" value="Submit" id="button">Search</button>

</form>

<div>${sessionScope.cruise.toString()}</div>

</body>
</html>

