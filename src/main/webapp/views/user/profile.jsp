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
    .disabled-btn {
        pointer-events: none;
        opacity: 0.6;
    }
  </style>
</head>

<body>
<%@include file="/common/header.jsp"%>
  <main>
    <div class="container-fluid mt-3">
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">Danh Sách Sản Phẩm</h3>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th>Mã đơn hàng</th>
                      <th>Tên người đặt</th>
                      <th>Email</th>
                      <th>Địa Chỉ</th>
                      <th>Tổng Tiền</th>
                      <th>Ngày Đặt</th>
                      <th>Trạng Thái</th>
                      <th>Xử Lý</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="order" items="${orders}">
                      <tr>
                        <td>${order.id}</td>
                        <td>${order.user.name}</td>
                        <td>${order.user.email}</td>
                        <td>${order.address}</td>
                        <td>${order.amount}</td>
                        <td>${order.createdate}</td>
                        <td>${order.orderstatus}</td>
                        <td>
                          <div class="row">
                            <c:choose>
                              <c:when test="${order.orderstatus == 'canceled'}">
                                <button type="button" class="btn btn-sm btn-danger mr-2 disabled-btn">Đã hủy</button>
                              </c:when>
                              <c:otherwise>
                                <a type="button" role="button" href="${pageContext.request.contextPath}/users/order/cancel/${order.id}" class="btn btn-sm btn-danger mr-2">Hủy</a>
                              </c:otherwise>
                            </c:choose>
                            <a type="button" role="button" href="${pageContext.request.contextPath}/users/order/details/${order.id}" class="btn_1">Chi tiết</a>
                          </div>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  <%@include file="/common/footer.jsp"%>

  <!-- Search model Begin -->
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
  <script src="<c:url value='/templates/user/assets/js/vendor/jquery-1.12.4.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/popper.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.slicknav.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/owl.carousel.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/slick.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/wow.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/animated.headline.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.scrollUp.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.nice-select.min.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.sticky.js'/>"></script>
  <script src="<c:url value='/templates/user/assets/js/jquery.magnific-popup.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/contact.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/jquery.form.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/jquery.validate.min.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/mail-script.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/jquery.ajaxchimp.min.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/plugins.js'/>"></script> 
  <script src="<c:url value='/templates/user/assets/js/main.js'/>"></script> 
</body>
</html>
