 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
  <style>
    .cart-table th {
        color: red;
        font-size: 1.5rem;
    }
  </style>
</head>

<body>
<%@include file="/common/header.jsp"%>
  <main>
    <!-- Hero Area Start-->
    <div class="slider-area h-50">
        <div class="single-slider slider-height2 d-flex align-items-center" style="min-height: 200px">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>Cart List</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--================Cart Area =================-->
    <section class="cart_area section_padding" style="padding-top: 20px;">
      <div class="container">
        <div class="cart_inner">
          <div class="table-responsive">
            <table class="table cart-table">
              <thead>
                <tr>
                  <th scope="col" style=" font-size: 30px;  color: red;">Product</th>
                  <th scope="col" style=" font-size: 30px;  color: red;">Price</th>
                  <th scope="col" style=" font-size: 30px;  color: red;">Quantity</th>
                  <th scope="col" style=" font-size: 30px;  color: red;">Total</th>
                  <th scope="col" style=" font-size: 30px;  color: red;">Remove</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="item" items="${cart}">
                  <tr>
                    <td>
                      <div class="media">
                        <div class="d-flex">
                          <img src="<c:url value='/templates/user/assets/img/gallery/${item.product.image}'/>" alt="${item.product.name}" />
                        </div>
                        <div class="media-body">
                          <p>${item.product.name}</p>
                        </div>
                      </div>
                    </td>
                    <td>
                      <h5>${item.product.price}</h5>
                    </td>
                    <td>
                      <div class="row input-group">
					    <span class="col-sm-2 text-center input-group-text input-number-decrement" > <a href="/decreaseQuantity/${item.product.id}"> <i class="ti-minus"></i></a></span>
					    <input class="col-sm-8 text-center form-control input-number" type="text" value="${item.quantity}" min="0" max="10">
					    <span class="col-sm-2 text-center input-group-text input-number-increment" ><a href="/increaseQuantity/${item.product.id}"><i class="ti-plus"></i></a></span>
					</div>

                    </td>
                    <td>
                      <h5>${item.product.price * item.quantity}</h5>
                    </td>
                    <td>
                      <a class="btn_1" href="<c:url value='/remove-from-cart?id=${item.product.id}'/>">Remove</a>
                    </td>
                  </tr>
                </c:forEach>
                <tr class="bottom_button">
                  <td>
                    <a class="btn_1" href="/clear-cart">Clear Cart</a>
                  </td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>
                    <div class="cupon_text float-right">
                      <a class="btn_1" href="#">Close Coupon</a>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td>
                    <h5>Subtotal</h5>
                  </td>
                  <td>
                    <h5>
                      <c:set var="subtotal" value="0" />
                      <c:forEach var="item" items="${cart}">
                        <c:set var="subtotal" value="${subtotal + (item.product.price * item.quantity)}" />
                      </c:forEach>
                      ${subtotal}
                    </h5>
                  </td>
                  <td></td>
                </tr>
              </tbody>
            </table>
            <div class="checkout_btn_inner float-right">
              <a class="btn_1" href="<c:url value='/home'/>">Continue Shopping</a>
              <a class="btn_1 checkout_btn_1" href="<c:url value='/order/proceedToCheckout'/>">Proceed to checkout</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Cart Area =================-->
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
  <script src="<c:url value='/templates/user/assets/js/wow.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/animated.headline.js'/>"></script>

  <!-- Scrollup, nice-select, sticky -->
  <script src="<c:url value='/templates/user/assets/js/jquery.scrollUp.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.nice-select.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.sticky.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.magnific-popup.js'/>"></script> 

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
