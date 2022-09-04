<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html language = "${param.lang}">
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
  <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Update cruise</title>
  <link rel="stylesheet" href="css/Style.css">
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<section class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5"><fmt:message key="label.update"/></h2>

              <form action="<%= request.getContextPath() %>/EditCruiseForm?id=<%= request.getParameter("id")%>" method="post">

                <div class="form-outline mb-4">
                  <input type="text" required = "required" placeholder="<fmt:message key="label.cruiseName"/>" id="form3Example1cg" class="form-control form-control-lg" name="cruiseName" value="${cruise.getCruiseName()}"/>
                  <label class="form-label" for="form3Example1cg"></label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" required = "required" placeholder="<fmt:message key="label.priceADMINADD"/>" id="form3Example2cg" class="form-control form-control-lg" name = "price" value="${cruise.getPrice()}"/>
                  <label class="form-label" for="form3Example1cg"></label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" required = "required" placeholder="<fmt:message key="label.durationADMINADD"/>" id="form3Example3cg" class="form-control form-control-lg" name = "duration" value="${cruise.getDuration()}"/>
                  <label class="form-label" for="form3Example3cg"></label>
                </div>

                <div class="form-outline mb-4">
                  <input type="date" required = "required" placeholder="<fmt:message key="label.startDateADMINADD"/>" id="form3Example4cg" class="form-control form-control-lg" name = "cruiseStartDate" value="${cruise.getCruiseStartDate()}"/>
                  <label class="form-label" for="form3Example4cg"></label>
                </div>

                <div class="form-outline mb-4">
                  <input type="date" required = "required" placeholder="<fmt:message key="label.endDateADMINADD"/>" id="form3Example5cg" class="form-control form-control-lg" name = "cruiseEndDate" value="${cruise.getCruiseEndDate()}"/>
                  <label class="form-label" for="form3Example1cg"></label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" required = "required" placeholder="<fmt:message key="label.passengerADMINADD"/>" id="form3Example6cg" class="form-control form-control-lg" name = "passengerCapacity" value="${cruise.getPassengerCapacity()}"/>
                  <label class="form-label" for="form3Example1cg"></label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" required = "required" placeholder="<fmt:message key="label.DestinationADMIN"/>" id="form3Example7cg" class="form-control form-control-lg" name = "destination" value="${cruise.getDestination()}"/>
                  <label class="form-label" for="form3Example1cg"></label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" required = "required" placeholder="<fmt:message key="label.linerNameADMINADD"/>" id="form3Example8cg" class="form-control form-control-lg" name = "cruiseLinerName" value="${cruise.getCruiseLinerName()}"/>
                  <label class="form-label" for="form3Example1cg"></label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" required = "required" placeholder="<fmt:message key="label.departureADMINADD"/>" id="form3Example9cg" class="form-control form-control-lg" name = "departure" value="${cruise.getDeparture()}"/>
                  <label class="form-label" for="form3Example1cg"></label>
                </div>

                <div class="d-flex justify-content-center">
                  <button type="submit" value="Submit"
                          class="btn btn-success btn-block btn-lg gradient-custom-4 text-body"><fmt:message key="label.updateButton"/></button>
                </div>

              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>