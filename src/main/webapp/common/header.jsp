	<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <!-- Preloader Start -->
    <header>
        <!-- Header Start -->
        <div class="header-area">
            <div class="main-header header-sticky">
                <div class="container-fluid">
                    <div class="menu-wrapper">
                        <!-- Logo -->
                        <div class="logo">
                            <a href="/home"><img src="<c:url value='/templates/user/assets/img/logo/logo.png'/>" alt=""></a>
                        </div>
                        <!-- Main-menu -->
                        <div class="main-menu d-none d-lg-block">
                            <nav>                                                
                                <ul id="navigation">  
                                    <li><a href="/home">Home</a></li>
                                    <li><a href="/shop">shop</a></li>
                                    <li><a href="about.html">about</a></li>
                                    <li class="hot"><a href="#">Latest</a>
                                        <ul class="submenu">
                                            <li><a href="shop.html"> Product list</a></li>
                                            <li><a href="product_details.html"> Product Details</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="blog.html">Blog</a>
                                        <ul class="submenu">
                                            <li><a href="blog.html">Blog</a></li>
                                            <li><a href="blog-details.html">Blog Details</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#">Pages</a>
                                        <ul class="submenu">
                                            <li><a href="login.html">Login</a></li>
                                            <li><a href="cart.html">Cart</a></li>
                                            <li><a href="elements.html">Element</a></li>
                                            <li><a href="confirmation.html">Confirmation</a></li>
                                            <li><a href="checkout.html">Product Checkout</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="contact.html">Contact</a></li>
                                </ul>
                            </nav>
                        </div>
                        <!-- Header Right -->
						<div class="header-right">
						    <ul>
						       <c:if test="${not empty user}">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle text-dark" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            ${user.name}
        </a>
        <div class="dropdown-menu" aria-labelledby="userDropdown">
            <c:choose>
                <c:when test="${user.admin == 'true'}">
                    <a class="dropdown-item" href="<c:url value='/admin/home'/>">Profile</a>
                </c:when>
                <c:otherwise>
                    <a class="dropdown-item" href="<c:url value='/users/profile'/>">Profile</a>
                </c:otherwise>
            </c:choose>
            <a class="dropdown-item" href="<c:url value='/users/logout'/>">Logout</a>
        </div>
    </li>
</c:if>
<c:if test="${empty user}">
    <li><a href="<c:url value='/views/user/login.jsp'/>"><span class="flaticon-user"></span>Login</a></li>
</c:if>

						        <li><a href="<c:url value='/views/user/cart.jsp'/>"><span class="flaticon-shopping-cart"></span></a></li>
						    </ul>
						</div>


                    </div>
                    <!-- Mobile Menu -->
                    <div class="col-12">
                        <div class="mobile_menu d-block d-lg-none"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
    </header>