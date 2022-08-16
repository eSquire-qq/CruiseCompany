<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/PaymentCss.css">
</head>
<body>
<div class="container d-flex justify-content-center mt-5">
  <div class="card">z

    <div>
      <div class="d-flex pt-3 pl-3">
        <div><img src="https://img.icons8.com/ios-filled/50/000000/visa.png" width="60" height="80" /></div>
        <div class="mt-3 pl-2"><span class="name">Martina Thomas</span><div><span class="cross">&#10005&#10005&#10005&#10005</span><span class="pin ml-2">8880</span></div></div>
      </div>

      <div class="py-2  px-3">
        <div class="first pl-2 d-flex py-2">
          <div class="form-check">
            <input type="radio" name="optradio" class="form-check-input mt-3 dot" checked>
          </div>
          <div class="border-left pl-2"><span class="head">Total amount due</span><div><span class="dollar">$</span><span class="amount">8245</span></div></div>

        </div>
      </div>

      <div class="py-2  px-3">
        <div class="second pl-2 d-flex py-2">
          <div class="form-check">
            <input type="radio" name="optradio" class="form-check-input mt-3 dot">
          </div>
          <div class="border-left pl-2"><span class="head">Other amount</span><div class="d-flex"><span class="dollar">$</span><input type="text" name="text" class="form-control ml-1" placeholder="0"></div></div>

        </div>
      </div>

      <div class="d-flex justify-content-between px-3 pt-4 pb-3">
        <div><span class="back">Go back</span></div>
        <button type="button" class="btn btn-primary button">Pay amount</button>
      </div>

    </div>
  </div>

</div>
</body>
</html>
