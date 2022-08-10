<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.cruisecompany.dao.CruiseDAO" %>
<%@page import="com.example.cruisecompany.entity.Cruise" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add new cruise</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<form action="<%= request.getContextPath() %>/AddNewCruise" method="post">
    <div class="container">
        <h1>Add new cruiser</h1>
        <p>Please fill in this form to create an cruise.</p>

        <label for="duration" id="dr">Duration:</label>
        <input type="text" name="duration" id="duration"><br/>

        <label  for="price" id="pr">Price:</label>
        <input type="text" name="price" id="price"><br/>

        <label  for="cruiseStartDate" id="csd">Cruise end date:</label>
        <input type="text" name="cruiseStartDate" id="cruiseStartDate"><br/>

        <label  for="cruiseEndDate" id="ced">Cruise end date:</label>
        <input type="text" name="cruiseEndDate" id="cruiseEndDate"><br/>


        <label  for="cruiseLinerName" id="cln">Cruise liner name:</label>
        <input type="text" name="cruiseLinerName" id="cruiseLinerName"><br/>

        <label  for="passengerCapacity" id="pc">Passenger capacity:</label>
        <input type="text" name="passengerCapacity" id="passengerCapacity"><br/>

    </div>

    <button type="submit" value="Submit" id="button">Register</button>
    <a href="HomePage.jsp">Back to Home</a>

</form>
</body>
</html>