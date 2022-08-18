<%--suppress ALL --%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cruisecompany.dao.CruiseDAO" %>
<%@ page import="com.example.cruisecompany.servlets.ShowCruise" %>
<%@ page import="com.example.cruisecompany.entity.Cruise" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();
    List<Cruise> cruises = cruiseDAO.readAll();
%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

<div class="container" style="background-color: #2c656a">
    <div class="card-header my-lg-3" style="text-align: center; color: #fff; font-family: 'Mulish', sans-serif; font-size: 2vmin;">Available cruises</div>
    <div class="row">
        <%
            if (!cruises.isEmpty()){
                for (Cruise cruise : cruises){
        %>
        <div class="col-md-4 my-3" style="padding-bottom: 2rem;">
            <div class="card" style="width: 19rem; height: 25rem; margin: auto" >
                <div class="card-body">
                    <h5 class="card-title">Cruise name: <%= cruise.getCruiseName()%></h5>
                    <h6 class="card-title">Destination <%= cruise.getDestination()%></h6>
                    <h6 class="card-title">Duration: <%= cruise.getDuration()%> </h6>
                    <h6 class="card-title">Passenger capacity: <%= cruise.getPassengerCapacity()%> </h6>
                    <h6 class="card-title">Price: <%= cruise.getPrice()%>$ </h6>
                    <h6 class="card-title">Dates: <%=cruise.getCruiseStartDate()%> - <%=cruise.getCruiseEndDate()%> </h6>
                    <a href="test.jsp" class="btn btn-primary" style="background-color: #448b85; border-color: #448b85;">View</a>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</div>

</body>
</html>