<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="zxx">
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Order Details | eCommers</title>
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
    <div class="container-fluid mt-3">
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">Chi Tiết Đơn Hàng</h3>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th>Tên sản phẩm</th>
                      <th>Số lượng</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="orderDetail" items="${orderDetails}">
                      <tr>
                        <td>${orderDetail.product.name}</td>
                        <td>${orderDetail.quantity}</td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
                <div class="mt-3">
                  <a href="${pageContext.request.contextPath}/users/profile" class="btn btn-secondary">Quay lại</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  <%@include file="/common/footer.jsp"%>
</body>
</html>
