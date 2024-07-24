 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>SeeTing Shop</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/templates/user/assets/img/favicon.ico'/>">

    <!-- CSS here -->
    <%@include file="/common/head.jsp"%>
</head>

<body>
    <!--? Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="<c:url value='/templates/user/assets/img/logo/logo.png'/>" alt="">
                </div>
            </div>
        </div>
    </div>
<%@include file="/common/header.jsp"%>
    <main>
        <!--? slider Area Start -->
        <div class="slider-area ">
            <div class="slider-active">
                <!-- Single Slider -->
                <div class="single-slider slider-height d-flex align-items-center slide-bg">
                    <div class="container">
                        <div class="row justify-content-between align-items-center">
                            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-8">
                                <div class="hero__caption">
                                    <h1 data-animation="fadeInLeft" data-delay=".4s" data-duration="2000ms">Đeo theo cách của bạn</h1>
                                    <p data-animation="fadeInLeft" data-delay=".7s" data-duration="2000ms">Và bán theo cách của chúng tôi.</p>
                                    <!-- Hero-btn -->
                                    <div class="hero__btn" data-animation="fadeInLeft" data-delay=".8s" data-duration="2000ms">
                                        <a href="industries.html" class="btn hero-btn">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-4 col-sm-4 d-none d-sm-block">
                                <div class="hero__img" data-animation="bounceIn" data-delay=".4s">
                                    <img src="<c:url value='/templates/user/assets/img/hero/watch.png'/>" alt="" class=" heartbeat">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Single Slider -->
                <div class="single-slider slider-height d-flex align-items-center slide-bg">
                    <div class="container">
                        <div class="row justify-content-between align-items-center">
                            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-8">
                                <div class="hero__caption">
                                    <h1 data-animation="fadeInLeft" data-delay=".4s" data-duration="2000ms">Select Your New Perfect Style</h1>
                                    <p data-animation="fadeInLeft" data-delay=".7s" data-duration="2000ms">Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat is aute irure.</p>
                                    <!-- Hero-btn -->
                                    <div class="hero__btn" data-animation="fadeInLeft" data-delay=".8s" data-duration="2000ms">
                                        <a href="industries.html" class="btn hero-btn">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-4 col-sm-4 d-none d-sm-block">
                                <div class="hero__img" data-animation="bounceIn" data-delay=".4s">
                                    <img src="<c:url value='/templates/user/assets/img/hero/watch.png'/>" alt="" class=" heartbeat">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- slider Area End-->
        <!-- ? New Product Start -->
        <section class="new-product-area section-padding30">
            <div class="container">
                <!-- Section tittle -->
                <div class="row">
                    <div class="col-xl-12">
                        <div class="section-tittle mb-70">
                            <h2>Top Sản Phẩm</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                        <div class="single-new-pro mb-30 text-center">
                            <div class="product-img">
                                <img src="<c:url value='/templates/user/assets/img/gallery/new_product1.png'/>" alt="">
                            </div>
                            <div class="product-caption">
                                <h3><a href="product_details.html">Đồng Hồ Phong Cách</a></h3>
                                <span> 45,743 VND</span>
                            </div>
                        </div>
                    </div>  
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                        <div class="single-new-pro mb-30 text-center">
                            <div class="product-img">
                                <img src="<c:url value='/templates/user/assets/img/gallery/new_product2.png'/>" alt="">
                            </div>
                            <div class="product-caption">
                                <h3><a href="product_details.html">Đồng Hồ Thời Thượng</a></h3>
                                <span> 45,743 VND</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                        <div class="single-new-pro mb-30 text-center">
                            <div class="product-img">
                                <img src="<c:url value='/templates/user/assets/img/gallery/new_product3.png'/>" alt="">
                            </div>
                            <div class="product-caption">
                                <h3><a href="product_details.html">Đồng Hồ Thái Công</a></h3>
                                <span> 45,743 VND</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--  New Product End -->
        <!--? Gallery Area Start -->
        <div class="gallery-area">
            <div class="container-fluid p-0 fix">
                <div class="row">
                    <div class="col-xl-6 col-lg-4 col-md-6 col-sm-6">
                        <div class="single-gallery mb-30">
                            <div class="gallery-img big-img" style="background-image: url(<c:url value='/templates/user/assets/img/gallery/gallery1.png'/>);"></div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
                        <div class="single-gallery mb-30">
                            <div class="gallery-img big-img" style="background-image: url(<c:url value='/templates/user/assets/img/gallery/gallery2.png'/>);"></div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-4 col-md-12">
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-6">
                                <div class="single-gallery mb-30">
                                    <div class="gallery-img small-img" style="background-image: url(<c:url value='/templates/user/assets/img/gallery/gallery3.png'/>);"></div>
                                </div>
                            </div>
                            <div class="col-xl-12 col-lg-12  col-md-6 col-sm-6">
                                <div class="single-gallery mb-30">
                                    <div class="gallery-img small-img" style="background-image: url(<c:url value='/templates/user/assets/img/gallery/gallery4.png'/>);"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- Gallery Area End -->
        <!--? Popular Items Start -->
        <div class="popular-items section-padding30">
            <div class="container">
                <!-- Section tittle -->
                <div class="row justify-content-center">
                    <div class="col-xl-7 col-lg-8 col-md-10">
                        <div class="section-tittle mb-70 text-center">
                            <h2>Danh Mục</h2>
                            <p>Đồng hồ cao cấp mang lại sự sang trọng, đẳng cấp và phong cách tinh tế cho người sử dụng, thể hiện cá tính và địa vị.</p>
                        </div>
                    </div>
                </div>
                 <div class="row">
    <c:forEach var="product" items="${products}">
        <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
            <div class="single-popular-items mb-50 text-center">
                <div class="popular-img">
                    <img src="<c:url value='/templates/user/assets/img/gallery/${product.image}'/>" alt="${product.name}">
                    <div class="img-cap" h>
                        <span> <a href="/add-to-cart/${product.id}" class="btn btn-primary">Thêm vào giỏ hàng</a></span>
                    </div>
                    <div class="favorit-items">
                        <span class="flaticon-heart"></span>
                    </div>
                </div>
                <div class="popular-caption">
                    <h3><a href="/productDetail/${product.id}">${product.name}</a></h3>
                    <span>${product.price} VND</span>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

                <!-- Button -->
                <div class="row justify-content-center">
                    <div class="room-btn pt-70">
                        <a href="/shop" class="btn view-btn1">View More Products</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Popular Items End -->
        <!--? Video Area Start -->
        <div class="video-area">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-lg-12">
                    <div class="video-wrap">
                        <div class="play-btn "><a class="popup-video" href="https://www.youtube.com/watch?v=asFi0Kvd8Us"><i class="fas fa-play"></i></a></div>
                    </div>
                    </div>
                </div>
                <!-- Arrow -->
                <div class="thumb-content-box">
                    <div class="thumb-content">
                        <h3>Next Video</h3>
                        <a href="#"> <i class="flaticon-arrow"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Video Area End -->
        <!--? Shop Method Start-->
        <div class="shop-method-area mt-3">
            <div class="container">
                <div class="method-wrapper">
                    <div class="row d-flex justify-content-between">
                        <div class="col-xl-4 col-lg-4 col-md-6">
                            <div class="single-method mb-40">
                                <i class="ti-package"></i>
                                <h6>Free Shipping Method</h6>
                                <p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
                            </div>
                        </div>
                        <div class="col-xl-4 col-lg-4 col-md-6">
                            <div class="single-method mb-40">
                                <i class="ti-unlock"></i>
                                <h6>Secure Payment System</h6>
                                <p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
                            </div>
                        </div> 
                        <div class="col-xl-4 col-lg-4 col-md-6">
                            <div class="single-method mb-40">
                                <i class="ti-reload"></i>
                                <h6>Secure Payment System</h6>
                                <p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Shop Method End-->
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

    <!-- Scrollup, nice-select, sticky -->
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