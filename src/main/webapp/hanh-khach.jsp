<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hành khách</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container my-4">
    <div class="row g-4">
        <div class="col-md-4">
            <div class="card shadow-sm h-100">
                <div class="card-header bg-success text-white">
                    <h5 class="mb-0">Đăng Ký Hành Khách</h5>
                </div>
                <div class="card-body">
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger p-2 small">
                            <i class="fas fa-exclamation-circle me-1"></i> ${error}
                        </div>
                    </c:if>
                    <form action="hanh-khach" method="post">
                        <div class="mb-3">
                            <label class="form-label">Họ tên</label>
                            <input type="text" name="hoTen" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số điện thoại</label>
                            <input type="text" name="soDienThoai" class="form-control" pattern="0[0-9]{9}" title="SĐT phải có 10 chữ số và bắt đầu bằng số 0" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-success w-100">Đăng Ký</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-8">
            <div class="card shadow-sm">
                <div class="card-header bg-white border-bottom py-3">
                    <form action="hanh-khach" method="get" class="row g-2">
                        <div class="col-9">
                            <input type="text" name="keyword" class="form-control" placeholder="Tìm theo tên, SĐT...">
                        </div>
                        <div class="col-3">
                            <button type="submit" class="btn btn-outline-success w-100"><i class="fas fa-search me-1"></i>Tìm</button>
                        </div>
                    </form>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover mb-0">
                        <thead class="table-light">
                        <tr><th>Mã</th><th>Họ tên</th><th>Số điện thoại</th><th>Email</th></tr>
                        </thead>
                        <tbody>
                        <%-- Kiểm tra listHK có đúng tên với setAttribute trong Servlet không --%>
                        <c:forEach var="p" items="${listHK}">
                            <tr>
                                <td>${p.maHanhKhach}</td>
                                <td>${p.hoTen}</td>
                                <td>${p.soDienThoai}</td>
                                <td>${p.email}</td>
                            </tr>
                        </c:forEach>

                        <%-- Mẹo kiểm tra: Nếu list trống, hiện dòng thông báo --%>
                        <c:if test="${empty listHK}">
                            <tr>
                                <td colspan="4" class="text-center">Không tìm thấy dữ liệu trong hệ thống!</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
