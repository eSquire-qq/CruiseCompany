<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <c:forEach var="cruise" items="${cruises}">
        <p>
        <td>
                ${cruise.getCruiseLinerName()}
        </td>
        </p>
    </c:forEach>
</div>

</body>
</html>

