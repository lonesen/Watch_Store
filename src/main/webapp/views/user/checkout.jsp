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
                                <h2>Checkout</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--================Checkout Area =================-->
        <section class="checkout_area section_padding">
          <div class="container">
            <div class="billing_details">
              <div class="row">
                <div class="col-lg-8">
                  <h3>Billing Details</h3>
                 <form class="row contact_form" action="/order/checkout" method="post" novalidate="novalidate">
				  <div class="col-md-12 form-group p_star">
				    <input type="text" class="form-control" id="city" name="city" placeholder="Town/City"/>
				  </div>
				  <div class="col-md-12 form-group p_star">
				    <input type="text" class="form-control" id="add1" name="address" placeholder="Address line" />
				  </div>
				  <div class="col-md-12 form-group">
				    <div class="creat_account">
				      <h3>Shipping Details</h3>
				      <input type="checkbox" id="f-option3" name="selector" />
				      <label for="f-option3">Ship to a different address?</label>
				    </div>
				    <textarea class="form-control" name="message" id="message" rows="1" placeholder="Order Notes"></textarea>
				  </div>
				  <button type="submit" class="btn_3">Proceed to Paypal</button>
				</form>

                </div>
                <div class="col-lg-4">
                  <div class="order_box">
                    <h2>Your Order</h2>
                    <ul class="list">
                      <li>
                        <a href="#">Product
                          <span>Total</span>
                        </a>
                      </li>
                      <c:forEach var="item" items="${cartItems}">
                        <li>
                          <a href="/productDetail/${item.product.id}">${item.product.name}
                            <span class="middle">x ${item.quantity}</span>
                            <span class="last">$ ${item.product.price * item.quantity}</span>
                          </a>
                        </li>
                      </c:forEach>
                    </ul>
                    <ul class="list list_2">
                      <li>
                        <a href="#">Subtotal
                          <span>$<c:out value="${cartTotal}"/></span>
                        </a>
                      </li>
                      <li>
                        <a href="#">Shipping
                          <span>Flat rate: $00.00</span>
                        </a>
                      </li>
                      <li>
                        <a href="#">Total
                          <span>$<c:out value="${cartTotal}"/></span>
                        </a>
                      </li>
                    </ul>
                    

                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
        <!--================End Checkout Area =================-->
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
    <script src="<c:url value='/templates/user/assets/js/jquery.magnific-popup.js'/>"></script>

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
