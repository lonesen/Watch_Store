<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %> --%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="zxx">
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Watch shop | eCommers</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="manifest" href="site.webmanifest">
  <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

  <!-- CSS here -->
  <%@include file="/common/head.jsp"%>
</head>

<body>
  <%@include file="/common/header.jsp"%>
  <main>
      <!-- Hero Area Start-->
      <div class="slider-area ">
          <div class="single-slider slider-height2 d-flex align-items-center">
              <div class="container">
                  <div class="row">
                      <div class="col-xl-12">
                          <div class="hero-cap text-center">
                              <h2>Confirmation</h2>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <!--================ confirmation part start =================-->
      <section class="confirmation_part section_padding">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <div class="confirmation_tittle">
                <span>Thank you. Your order has been received.</span>
              </div>
            </div>
            <div class="col-lg-6 col-lx-4">
              <div class="single_confirmation_details">
                <h4>Order Info</h4>
                <ul>
                  <li>
                    <p>Order Number</p><span>: ${order.id}</span>
                  </li>
                  <li>
                    <p>Date</p><span>: ${order.createdate}</span>
                  </li>
                  <li>
                    <p>Total</p><span>: USD ${order.amount}</span>
                  </li>
                  <li>
                    <p>Address</p><span>: ${order.address}</span>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-12">
              <div class="order_details_iner">
                <h3>Order Details</h3>
                <table class="table table-borderless">
                  <thead>
                    <tr>
                      <th scope="col" colspan="2">Product</th>
                      <th scope="col">Quantity</th>
                      <th scope="col">Total</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="item" items="${cart}">
                      <tr>
                        <th colspan="2"><span>${item.product.name}</span></th>
                        <th>x${item.quantity}</th>
                        <th><span>$${item.product.price * item.quantity}</span></th>
                      </tr>
                    </c:forEach>
                    <tr>
                      <th colspan="3">Shipping</th>
                      <th><span>Flat rate: $0</span></th>
                    </tr>
                  </tbody>
                  <tfoot>
                    <tr>
                      <th scope="col" colspan="3">Total</th>
                      <th scope="col">$${order.amount}</th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!--================ confirmation part end =================-->
  </main>
  <%@include file="/common/footer.jsp"%>
  <!--? Search model Begin -->
  <div class="search-model-box">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-btn">+</div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Searching key.....">
        </form>
    </div>
  </div>
  <!-- Search model end -->

  <!-- JS here -->
  <script src="<c:url value='/templates/user/assets/js/vendor/modernizr-3.5.0.min.js'/>"></script>

  <!-- Jquery, Popper, Bootstrap -->
  <script src="<c:url value='/templates/user/assets/js/vendor/jquery-1.12.4.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/popper.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/bootstrap.min.js'/>"></script>
  <!-- Jquery Mobile Menu -->
  <script src="<c:url value='/templates/user/assets/js/jquery.slicknav.min.js'/>"></script>

  <!-- Jquery Slick , Owl-Carousel Plugins -->
  <script src="<c:url value='/templates/user/assets/js/owl.carousel.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/slick.min.js'/>"></script>

  <!-- One Page, Animated-HeadLin -->
  <script src="<c:url value='/templates/user/assets/js/jquery.magnific-popup.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/wow.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/animated.headline.js'/>"></script>

  <!-- Scroll up, nice-select, sticky -->
  <script src="<c:url value='/templates/user/assets/js/jquery.scrollUp.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.nice-select.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.sticky.js'/>"></script> 

  <!-- contact js -->
  <script src="<c:url value='/templates/user/assets/js/contact.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/jquery.form.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/jquery.validate.min.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/mail-script.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/jquery.ajaxchimp.min.js'/>"></script> 

  <!-- Jquery Plugins, main Jquery -->	
  <script src="<c:url value='/templates/user/assets/js/plugins.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/main.js'/>"></script> 

</body>
</html>
