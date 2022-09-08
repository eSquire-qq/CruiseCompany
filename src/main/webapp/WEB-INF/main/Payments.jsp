<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.cruisecompany.dao.UserDAO" %>
<%@page import="com.example.cruisecompany.entity.User" %>

<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
  <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Sing up</title>
  <link rel="stylesheet" href="css/Style.css">
</head>
<body>
<section class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Payment</h2>

              <form action="Payments" enctype="multipart/form-data" method="post">

                <div class="card">

                  <div class="form-outline mb-4">
                    <input type="text" value="<%=request.getAttribute("cruisePrice")%>" required = "required"  id="form3Example3cg" class="form-control form-control-lg" name = "cruisePrice" readonly="readonly" />
                    <label class="form-label" for="form3Example3cg"></label>
                  </div>

                    <div class="ghost" style=" display: none;">
                      <input type="text" name="ticketId" class="form-control"  value="<%=request.getAttribute("ticketId")%>" readonly>
                    </div>

                    <div class="form-outline mb-4">
                      <label class="form-label" for="form3Example4cg">Завантажте ваші документи</label>
                      <input type="file" required = "required" id="form3Example4cg" class="form-control form-control-lg" name = "file" />
                    </div>

                    <div class="d-flex justify-content-center">
                      <button type="submit" value="Submit"
                              class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Payments</button> <!-- SET PARAMETERS -->
                    </div>
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
