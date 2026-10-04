# HỆ THỐNG QUẢN LÝ SÂN BAY (Airport Management)

<p>
  <img src="https://img.shields.io/badge/Java-17%2B-orange" alt="Java">
  <img src="https://img.shields.io/badge/Spring%20MVC-brightgreen" alt="Spring MVC">
  <img src="https://img.shields.io/badge/Hibernate%2FJPA-blue" alt="Hibernate/JPA">
  <img src="https://img.shields.io/badge/Build-Maven-red" alt="Maven">
</p>

> ℹ️ **Ghi chú:** đây là phiên bản liên quan đến repo [`quan-ly-san-bay`](https://github.com/nhunguy-swe/quan-ly-san-bay) — cùng đề bài Quản lý Sân bay, nhưng là bản làm lại/cập nhật khác. Nếu bạn đang xem profile này, hai repo phục vụ cùng một đề bài nhưng ở các mốc thời gian/phiên bản khác nhau.

## 1. Giới thiệu

Hệ thống Quản lý Sân bay được xây dựng nhằm hỗ trợ quản lý thông tin chuyến bay, hành khách và vé máy bay. Hệ thống cho phép quản lý lịch trình bay, đặt vé, cập nhật trạng thái chuyến bay và tra cứu thông tin hành khách, vé máy bay.

---

## 2. Công nghệ sử dụng

- Java
- Spring MVC
- Hibernate/JPA
- MySQL hoặc SQL Server
- JSP/Servlet
- Bootstrap 5 (tùy chọn)
- Maven

---

## 3. Thiết kế cơ sở dữ liệu

### Bảng CHUYEN_BAY

| Tên cột         | Kiểu dữ liệu              | Mô tả                          |
| --------------- | ------------------------- | --------------------------------|
| maChuyenBay     | INT (PK, AUTO_INCREMENT)  | Mã chuyến bay                     |
| soHieuChuyenBay | VARCHAR(50)                 | Số hiệu chuyến bay                  |
| ngayGioKhoiHanh | DATETIME                      | Ngày giờ khởi hành                    |
| ngayGioDen      | DATETIME                        | Ngày giờ đến                            |
| diemKhoiHanh    | VARCHAR(100)                      | Điểm khởi hành                            |
| diemDen         | VARCHAR(100)                        | Điểm đến                                    |
| trangThai       | VARCHAR(50)                           | Đúng giờ, Hoãn, Hủy, Đổi lịch                 |

### Bảng HANH_KHACH

| Tên cột     | Kiểu dữ liệu              | Mô tả         |
| ----------- | ------------------------- | ---------------|
| maHanhKhach | INT (PK, AUTO_INCREMENT)  | Mã hành khách    |
| hoTen       | VARCHAR(100)                | Họ tên             |
| soDienThoai | VARCHAR(10)                   | Số điện thoại         |
| email       | VARCHAR(100)                     | Email                    |

### Bảng VE_MAY_BAY

| Tên cột     | Kiểu dữ liệu              | Mô tả                            |
| ----------- | ------------------------- | ------------------------------------|
| maVe        | INT (PK, AUTO_INCREMENT)  | Mã vé                                 |
| maHanhKhach | INT (FK)                    | Hành khách                              |
| maChuyenBay | INT (FK)                      | Chuyến bay                                |
| loaiVe      | VARCHAR(50)                     | Hạng phổ thông, Hạng thương gia             |
| giaVe       | BIGINT                             | Giá vé                                        |
| thongBao    | VARCHAR(255)                          | Thông báo                                       |

### Bảng LICH_SU_CHUYEN_BAY

| Tên cột         | Kiểu dữ liệu              | Mô tả              |
| --------------- | ------------------------- | ---------------------|
| maLichSu        | INT (PK, AUTO_INCREMENT)  | Mã lịch sử             |
| maChuyenBay     | INT (FK)                    | Chuyến bay               |
| trangThaiCu     | VARCHAR(50)                   | Trạng thái cũ              |
| trangThaiMoi    | VARCHAR(50)                     | Trạng thái mới                |
| thoiGianCapNhat | DATETIME                           | Thời gian cập nhật              |

### Quan hệ dữ liệu

- Một hành khách có thể đặt nhiều vé.
- Một chuyến bay có thể có nhiều vé.
- Một chuyến bay có nhiều bản ghi lịch sử thay đổi trạng thái.
- Một vé thuộc duy nhất một hành khách và một chuyến bay.

---

## 4. Chức năng hệ thống

### 4.1 Quản lý Chuyến bay

Cho phép thêm mới: Số hiệu chuyến bay, Ngày giờ khởi hành, Ngày giờ đến, Điểm khởi hành, Điểm đến, Trạng thái chuyến bay.

**Validation — Ngày giờ đến:** phải sau ngày giờ khởi hành.
```
ngayGioDen.isAfter(ngayGioKhoiHanh)
```

**Danh sách trạng thái:** Đúng giờ, Hoãn, Hủy, Đổi lịch.

**Nghiệp vụ đặc biệt:** khi trạng thái chuyến bay được cập nhật thành Hoãn hoặc Hủy, hệ thống phải:
1. Cập nhật giá vé của tất cả vé thuộc chuyến bay đó thành `0`.
2. Cập nhật thông báo của các vé, ví dụ: `Chuyến bay đã bị hoãn` hoặc `Chuyến bay đã bị hủy`.
3. Lưu lịch sử thay đổi vào bảng `LICH_SU_CHUYEN_BAY`.

### 4.2 Quản lý Hành khách

Cho phép thêm mới: Họ tên, Số điện thoại, Email.

**Validation — Số điện thoại:** bắt đầu bằng số 0, gồm đúng 10 chữ số.
```
^0[0-9]{9}$
```

**Validation — Email:**
```java
@Email(message = "Email không hợp lệ")
private String email;
```

### 4.3 Quản lý Vé máy bay

Cho phép đặt vé, gồm: Hành khách (ComboBox từ CSDL), Chuyến bay (ComboBox từ CSDL), Loại vé, Giá vé, Thông báo.

**Danh sách Loại vé:** Hạng phổ thông, Hạng thương gia.

**Validation — Giá vé:** số nguyên không âm, chia hết cho 1.000.
```
giaVe >= 0 && giaVe % 1000 == 0
```
Hợp lệ: `90000`, `150000`, `500000`

---

## 5. Chức năng tìm kiếm

### 5.1 Tìm kiếm Hành khách

Tìm theo: Mã hành khách, Họ tên, Số điện thoại, Email. Kết quả: Mã hành khách, Họ tên, Số điện thoại, Email.

### 5.2 Tìm kiếm Vé máy bay

Tìm theo: Hành khách, Số hiệu chuyến bay. Kết quả: Mã vé, Số hiệu chuyến bay, Loại vé, Giá vé, Thông báo.

---

## 6. Kiến trúc dự án

```
src/main/java
│
├── controller
│   ├── ChuyenBayController
│   ├── HanhKhachController
│   ├── VeMayBayController
│   └── TimKiemController
│
├── entity
│   ├── ChuyenBay
│   ├── HanhKhach
│   ├── VeMayBay
│   └── LichSuChuyenBay
│
├── dao
│   └── SanBayDAO
│
├── service
│   └── ChuyenBayService
│
└── config
    ├── WebConfig
    └── HibernateConfig
```

---

## 7. Yêu cầu kỹ thuật

- **Framework:** Spring MVC, Hibernate/JPA
- **Mô hình MVC:** Controller xử lý request, Service xử lý nghiệp vụ, DAO thao tác dữ liệu, JSP hiển thị giao diện
- **Database:** MySQL hoặc SQL Server
- **Coding Convention:** PascalCase cho tên lớp, camelCase cho biến, phân tầng đầy đủ Controller - Service - DAO - Entity

---

## 8. Giao diện

Khuyến khích sử dụng: Bootstrap 5, Responsive Design, Navbar điều hướng, Form nhập liệu trực quan, Bảng dữ liệu đẹp.

---

## Bắt đầu (Getting Started)

### Yêu cầu

- JDK 17+
- MySQL hoặc SQL Server
- IDE: IntelliJ IDEA / Eclipse

### Cài đặt

```bash
git clone https://github.com/nhunguy-swe/airport-management-spring-mvc-v2.git
cd airport-management-spring-mvc-v2
```

### Cấu hình Database

1. Tạo các bảng `CHUYEN_BAY`, `HANH_KHACH`, `VE_MAY_BAY`, `LICH_SU_CHUYEN_BAY` theo thiết kế ở trên.
2. Cập nhật thông tin kết nối trong `HibernateConfig.java`.

> ⚠️ Không hard-code mật khẩu database trực tiếp trong code nếu push lên GitHub public — dùng biến môi trường hoặc file cấu hình đã thêm vào `.gitignore`.

### Chạy ứng dụng

```bash
mvn clean install
```

Deploy file `.war` lên **Apache Tomcat**, truy cập tại `http://localhost:8080/quan-ly-chuyen-bay/`.

---

## 9. Kết luận

Hệ thống đáp ứng đầy đủ các yêu cầu: Quản lý Chuyến bay · Quản lý Hành khách · Quản lý Vé máy bay · Quản lý Lịch sử chuyến bay · Validation dữ liệu đầu vào · Tìm kiếm Hành khách · Tìm kiếm Vé máy bay · Tự động cập nhật vé khi chuyến bay bị Hoãn hoặc Hủy · Áp dụng Spring MVC và Hibernate · Tuân thủ Java Coding Convention

---

## Tác giả

- GitHub: [@nhunguy-swe](https://github.com/nhunguy-swe)

---

## Giấy phép

Dự án này được thực hiện cho mục đích học tập/ôn thi cá nhân.
