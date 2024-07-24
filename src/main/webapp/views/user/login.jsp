<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Watch shop | eCommerce</title>
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
                                <h2>Login</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container text-center mt-3 " > 
         <h1 class="text-danger">${message}</h1>
        </div>
        <!-- Hero Area End-->
        <!--================login_part Area =================-->
        <section class="login_part section_padding " style=" padding-top: 20px; border-top-width: 20px;">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>Bạn là khách hàng mới!</h2>
                                <p>Đăng ký trở thành Con gà để nhận nhiều ưu đãi tốt nhé!! (❁´◡`❁)</p>
                                <a href="register.jsp" class="btn_3">Tạo tài khoản</a>
                            </div>
                        </div>
                    </div>
                   
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_form">
                            <div class="login_part_form_iner">
                                <h3>Welcome Back ! <br></h3>
                                    
									<form class="row contact_form" action="/users/login" method="post" novalidate="novalidate">
								    <div class="col-md-12 form-group p_star">
								        <input type="text" class="form-control" id="phone" name="phone" placeholder="Số Điện Thoại của bạn">
								    </div>
								    <div class="col-md-12 form-group p_star">
								        <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu">
								    </div>
								    <div class="col-md-12 form-group">
								        <div class="creat_account d-flex align-items-center">
								            <input type="checkbox" id="f-option" name="selector">
								            <label for="f-option">Remember me</label>
								        </div>
								        <button type="submit" value="submit" class="btn_3">
								            Đăng Nhập
								        </button>
								        <a class="lost_pass" href="#">Oh! no bạn quên mật khẩu?</a>
								    </div>
								</form>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================login_part end =================-->
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
