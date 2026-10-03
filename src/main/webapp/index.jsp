<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý chuyến bay</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container my-5">
    <div class="row mb-5 text-center">
        <div class="col-12">
            <h1 class="display-4 fw-bold text-dark">Hệ Thống Quản Lý Sân Bay</h1>
            <p class="lead text-muted">Quản lý chuyên nghiệp - Vận hành tối ưu</p>
            <hr class="w-25 mx-auto">
        </div>
    </div>

    <div class="row g-4">
        <div class="col-md-4">
            <div class="card h-100 shadow">
                <div class="card-body text-center p-4">
                    <div class="display-4 text-primary mb-3"><i class="fas fa-plane"></i></div>
                    <h4 class="card-title">Quản lý Chuyến Bay</h4>
                    <p class="card-text text-muted">Thêm mới chuyến bay, cập nhật trạng thái hoãn/hủy và xem lịch trình khởi hành.</p>
                    <a href="chuyen-bay" class="btn btn-outline-primary px-4 rounded-pill">Truy cập</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card h-100 shadow">
                <div class="card-body text-center p-4">
                    <div class="display-4 text-success mb-3"><i class="fas fa-user-check"></i></div>
                    <h4 class="card-title">Hành Khách</h4>
                    <p class="card-text text-muted">Đăng ký thông tin khách hàng mới và tra cứu thông tin hành khách trong hệ thống.</p>
                    <a href="hanh-khach" class="btn btn-outline-success px-4 rounded-pill">Truy cập</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card h-100 shadow">
                <div class="card-body text-center p-4">
                    <div class="display-4 text-warning mb-3"><i class="fas fa-ticket-alt"></i></div>
                    <h4 class="card-title">Vé & Đặt Chỗ</h4>
                    <p class="card-text text-muted">Xuất vé cho khách hàng, chọn loại vé và tự động cập nhật thông báo khi thay đổi lịch.</p>
                    <a href="ve-may-bay" class="btn btn-outline-warning px-4 rounded-pill">Truy cập</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-5">
        <div class="col-12">
            <div class="bg-white p-4 rounded-4 shadow-sm border-start border-primary border-4">
                <h5 class="fw-bold"><i class="fas fa-info-circle me-2 text-primary"></i>Lưu ý hệ thống</h5>
                <ul class="mb-0 small text-muted">
                    <li>Khi cập nhật trạng thái chuyến bay thành <strong>Hoãn</strong> hoặc <strong>Hủy</strong>, giá vé sẽ tự động chuyển về 0.</li>
                    <li>SĐT hành khách bắt buộc phải gồm 10 chữ số và bắt đầu bằng số 0.</li>
                    <li>Mọi thay đổi về lịch bay sẽ được ghi lại tự động trong <strong>Lịch sử chuyến bay</strong>.</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
