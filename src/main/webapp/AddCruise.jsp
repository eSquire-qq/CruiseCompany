<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.cruisecompany.dao.CruiseDAO" %>
<%@page import="com.example.cruisecompany.entity.Cruise" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add new cruise</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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

        <label  for="cruiseName" id="cn">Cruise name:</label>
        <input type="text" name="cruiseName" id="cruiseName"><br/>

    </div>

    <button type="submit" value="Submit" id="button">Register</button>
    <a href="HomePage.jsp">Back to Home</a>

</form>
</body>
</html>