<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <!-- Bootstrap 5 CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css" rel="stylesheet">
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
                            <h2>${product.name}</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Hero Area End-->
    <!--================Single Product Area =================-->
    <div class="product_image_area my-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="single_product_img text-center">
                        <img src="<c:url value='/templates/user/assets/img/gallery/${product.image}'/>" alt="${product.name}" class="img-fluid">
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="single_product_text text-center">
                        <h3>${product.name}</h3>
                        <p>
                            ${product.description}
                        </p>
                        <div class="card_area">
                            <div class="product_count_area d-flex justify-content-center align-items-center my-3">
                                <p class="me-3">Số lượng</p>
                                <div class="product_count d-inline-block">
                                    <button class="btn btn-outline-secondary btn-sm number-decrement" style="width: 50px; height: 50px; padding: 0;"><i class="bi bi-dash"></i></button>
                                    <input class="product_count_item input-number text-center" type="text" name ="quantity" value="1" min="1" max="10" style="width: 50px; height: 40px;">
                                    <button class="btn btn-outline-secondary btn-sm number-increment" style="width: 50px; height: 50px; padding: 0;"><i class="bi bi-plus"></i></button>
                                </div>
                                <p class="ms-3">${product.price} VND</p>
                            </div>
                            <div class="add_to_cart">
                                <a href="/add-to-cart/${product.id}" class="btn btn-primary">Thêm vào giỏ hàng</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--================End Single Product Area =================-->
    <!-- subscribe part here -->
    <section class="subscribe_part section_padding">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="subscribe_part_content">
                        <h2>Nhận thông tin khuyến mãi và cập nhật!</h2>
                        <p>Seamlessly empower fully researched growth strategies and interoperable internal or “organic” sources credibly innovate granular internal.</p>
                        <div class="subscribe_form">
                            <input type="email" placeholder="Nhập email của bạn" class="form-control">
                            <a href="#" class="btn btn-primary mt-3">Đăng ký</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- subscribe part end -->
</main>
<%@include file="/common/footer.jsp"%>

<!-- Bootstrap 5 JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<!-- JS here -->
<script src="<c:url value='/templates/user/assets/js/vendor/modernizr-3.5.0.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/vendor/jquery-1.12.4.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.slicknav.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/slick.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/wow.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/animated.headline.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.magnific-popup.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.scrollUp.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.nice-select.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.sticky.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/contact.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.form.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.validate.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/mail-script.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.ajaxchimp.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/plugins.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/main.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/swiper.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/mixitup.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/jquery.counterup.min.js'/>"></script>
<script src="<c:url value='/templates/user/assets/js/waypoints.min.js'/>"></script>
</body>
</html>
