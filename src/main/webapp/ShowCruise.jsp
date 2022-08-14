<%--suppress ALL --%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cruisecompany.dao.CruiseDAO" %>
<%@ page import="com.example.cruisecompany.servlets.ShowCruise" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

<div>
    <c:forEach var="cruise" items="${cruises}">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    <h4>${cruise.getCruiseName}</h4>
                </div>
                <div class="card-body">
                    <p class="card-text">
                    <td> ${cruise.getPrice()} </td>
                    <td> ${cruise.getCruiseStartDate()} </td>
                    <td> ${cruise.getCruiseStartDate()} </td>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>

