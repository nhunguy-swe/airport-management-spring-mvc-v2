<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chuyến bay</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container my-4">
    <div class="card shadow-sm mb-4">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0"><i class="fas fa-plus-circle me-2"></i>Thêm Chuyến Bay Mới</h5>
        </div>
        <div class="card-body">
            <form action="chuyen-bay?action=add" method="post" class="row g-3">
                <div class="col-md-3">
                    <label class="form-label">Số hiệu chuyến bay</label>
                    <input type="text" name="soHieu" class="form-control" placeholder="VD: VN123" required>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Điểm khởi hành</label>
                    <input type="text" name="diemKhoiHanh" class="form-control" required>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Điểm đến</label>
                    <input type="text" name="diemDen" class="form-control" required>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Trạng thái</label>
                    <select name="trangThai" class="form-select">
                        <option value="Đúng giờ">Đúng giờ</option>
                        <option value="Hoãn">Hoãn</option>
                        <option value="Hủy">Hủy</option>
                        <option value="Đổi lịch">Đổi lịch</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Ngày giờ khởi hành</label>
                    <input type="datetime-local" name="khoiHanh" class="form-control" required>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Ngày giờ đến</label>
                    <input type="datetime-local" name="den" class="form-control" required>
                </div>
                <div class="col-md-4 d-flex align-items-end">
                    <button type="submit" class="btn btn-primary w-100">Lưu Chuyến Bay</button>
                </div>
            </form>
            <c:if test="${not empty error}">
                <div class="alert alert-danger mt-3">${error}</div>
            </c:if>
        </div>
    </div>

    <div class="card shadow-sm">
        <div class="card-header bg-dark text-white">
            <h5 class="mb-0">Danh Sách Chuyến Bay</h5>
        </div>
        <div class="table-responsive">
            <table class="table table-hover align-middle mb-0">
                <thead class="table-light">
                <tr>
                    <th>Mã</th><th>Số hiệu</th><th>Lộ trình</th><th>Khởi hành</th><th>Trạng thái</th><th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="f" items="${listCB}">
                    <tr>
                        <td>${f.maChuyenBay}</td>
                        <td class="fw-bold text-primary">${f.soHieuChuyenBay}</td>
                        <td>${f.diemKhoiHanh} <i class="fas fa-long-arrow-alt-right mx-1"></i> ${f.diemDen}</td>
                        <td>${f.ngayGioKhoiHanh}</td>
                        <td>
                            <span class="badge rounded-pill ${f.trangThai == 'Hủy' ? 'bg-danger' : (f.trangThai == 'Hoãn' ? 'bg-warning' : 'bg-success')}">
                                    ${f.trangThai}
                            </span>
                        </td>
                        <td>
                            <form action="chuyen-bay?action=updateTrangThai" method="post" class="d-flex gap-2">
                                <input type="hidden" name="id" value="${f.maChuyenBay}">
                                <select name="status" class="form-select form-select-sm" onchange="this.form.submit()">
                                    <option value="">Cập nhật TT</option>
                                    <option value="Đúng giờ">Đúng giờ</option>
                                    <option value="Hoãn">Hoãn</option>
                                    <option value="Hủy">Hủy</option>
                                    <option value="Đổi lịch">Đổi lịch</option>
                                </select>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
