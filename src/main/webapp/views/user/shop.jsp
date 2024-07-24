
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- Font Awesome 5 CSS -->
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.7.2/css/all.css'>
<!-- Products List CSS -->
<link rel="stylesheet"
	href="<c:url value='/templates/user/Doc/css/shop/shop.css'/>">
<link rel="stylesheet"
	href="<c:url value='/templates/user/Doc/css/shop/styleShop.css'/>">


<!-- Demo CSS (No need to include it into your project) -->

<!-- CSS here -->
<%@include file="/common/head.jsp"%>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<main>
		<!-- DEMO HTML -->
		<div class="container bg-white">
			<nav class="navbar navbar-expand-md navbar-light bg-white">
				<div class="container-fluid p-0">
					<div class="row w-100">
						<!-- search -->
						<form action="/shop/shopSort" method="post"
							class="d-flex align-items-center ">
							<div class=" main-search-input-wrap m-0 w-100">
								<div class="main-search-input fl-wrap w-100">
									<div class="main-search-input-item">
										<input type="text" name="keywords" value="${keywords}"
											placeholder="Search Products...">
									</div>
									<button class="main-search-button">Search</button>
								</div>
							</div>
						</form>

						<div class="col-12 collapse navbar-collapse" id="myNav">
							<div class="navbar-nav ms-auto">
								<a class="nav-link active" aria-current="page" href="/shop">All</a>
								<a class="nav-link" href="/shop/shopSort?direction=asc&p=${page.number}">Price
									Low to High</a> <a class="nav-link"
									href="/shop/shopSort?direction=desc&p=${page.number}">Price High to Low</a>
								<div class="nav-link">
									<div class="">
										<select id="categorySelect" class="form-select form-select-sm h-25"
											name="category" onchange="location = this.value;">
											<option value="/shop">Choose Category</option>
											<c:forEach var="category" items="${categories}">
												<option
													value="/shop/shopSort?category=${category.name}&direction=${sortDirection}"
													${selectedCategory == category.name ? 'selected' : ''}>
													${category.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</nav>
			<div class="row pt-1">
				<c:forEach var="p" items="${page.content}">
					<div
						class="col-lg-3 col-sm-6 d-flex flex-column align-items-center justify-content-center product-item my-3">
						<div class="product">
							<img
								src="<c:url value='/templates/user/Doc/img/${p.getImage()}'/>"
								alt="">
							<ul
								class="d-flex align-items-center justify-content-center list-unstyled icons">
								<li class="icon"><span class="fas fa-expand-arrows-alt"></span></li>
								<li class="icon mx-3"><span class="far fa-heart"></span></li>
								<li class="icon"><span class="fas fa-shopping-bag"></span></li>
							</ul>
						</div>
						<div class="tag bg-red">${p.getCategory().getName()}</div>
						<div class="title pt-4 pb-1">${p.getName()}</div>
						<div class="d-flex align-content-center justify-content-center">
							<span class="fas fa-star"></span> <span class="fas fa-star"></span>
							<span class="fas fa-star"></span> <span class="fas fa-star"></span>
							<span class="fas fa-star"></span>
						</div>
						<div class="price">${p.getPrice()}VNĐ</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- EMD DEMO HTML -->
	</main>

	<%@include file="/common/footer.jsp"%>
	<!-- Bootstrap 5 JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>

</html>