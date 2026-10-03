<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Vé máy bay</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container my-4">
  <div class="row g-4">
    <div class="col-lg-4">
      <div class="card shadow-sm border-0">
        <div class="card-header bg-warning py-3">
          <h5 class="mb-0 fw-bold"><i class="fas fa-ticket-alt me-2"></i>Đặt Vé Mới</h5>
        </div>
        <div class="card-body bg-white">
          <form action="ve-may-bay" method="post">
            <div class="mb-3">
              <label class="form-label">Hành khách</label>
              <select name="maHK" class="form-select shadow-none">
                <c:forEach var="hk" items="${listHK}">
                  <option value="${hk.maHanhKhach}">${hk.hoTen} - ${hk.soDienThoai}</option>
                </c:forEach>
              </select>
            </div>
            <div class="mb-3">
              <label class="form-label">Số hiệu chuyến bay</label>
              <select name="maCB" class="form-select shadow-none">
                <c:forEach var="cb" items="${listCB}">
                  <option value="${cb.maChuyenBay}">${cb.soHieuChuyenBay} (${cb.diemKhoiHanh} - ${cb.diemDen})</option>
                </c:forEach>
              </select>
            </div>
            <div class="mb-3">
              <label class="form-label">Loại vé</label>
              <select name="loaiVe" class="form-select shadow-none">
                <option value="Pho thong">Hạng Phổ Thông (Economy)</option>
                <option value="Thuong gia">Hạng Thương Gia (Business)</option>
              </select>
            </div>
            <div class="mb-3">
              <label class="form-label">Giá vé (VNĐ)</label>
              <input type="number" name="giaVe" step="1000" min="0" class="form-control" required placeholder="VD: 90000">
            </div>
            <div class="mb-3">
              <label class="form-label">Thông báo ghi chú</label>
              <textarea name="thongBao" class="form-control" rows="2"></textarea>
            </div>
            <button type="submit" class="btn btn-warning w-100 fw-bold py-2 shadow-sm">Xác Nhận Đặt Vé</button>
          </form>
        </div>
      </div>
    </div>

    <div class="col-lg-8">
      <div class="card shadow-sm border-0">
        <div class="card-header bg-white py-3">
          <form action="ve-may-bay" method="get" class="row g-2">
            <div class="col-md-9">
              <input type="text" name="keyword" class="form-control" placeholder="Nhập số hiệu, tên hành khách để tìm vé...">
            </div>
            <div class="col-md-3">
              <button type="submit" class="btn btn-dark w-100">Tra Cứu Vé</button>
            </div>
          </form>
        </div>
        <div class="table-responsive">
          <table class="table table-hover align-middle mb-0">
            <thead class="table-light text-uppercase small fw-bold">
            <tr><th>Mã vé</th><th>Hành khách</th><th>Số hiệu</th><th>Hạng</th><th>Giá</th><th>Thông báo hệ thống</th></tr>
            </thead>
            <tbody>
            <c:forEach var="t" items="${listVe}">
              <tr>
                <td>#${t.maVe}</td>
                <td>${t.tenHanhKhach}</td>
                <td><span class="badge bg-light text-dark border">${t.soHieuChuyenBay}</span></td>
                <td>${t.loaiVe}</td>
                <td class="fw-bold text-success">${t.giaVe}đ</td>
                <td>
                  <c:if test="${t.giaVe == 0}">
                    <span class="text-danger fw-bold"><i class="fas fa-exclamation-triangle me-1"></i>${t.thongBao}</span>
                  </c:if>
                  <c:if test="${t.giaVe > 0}">
                    <span class="text-muted small">${t.thongBao}</span>
                  </c:if>
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

<%@ include file="footer.jsp" %>
</body>
</html>