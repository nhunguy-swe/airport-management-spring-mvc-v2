# HỆ THỐNG QUẢN LÝ SÂN BAY

## 1. Giới thiệu

Hệ thống Quản lý Sân bay được xây dựng nhằm hỗ trợ quản lý thông tin chuyến bay, hành khách và vé máy bay. Hệ thống cho phép quản lý lịch trình bay, đặt vé, cập nhật trạng thái chuyến bay và tra cứu thông tin hành khách, vé máy bay.

---

## 2. Công nghệ sử dụng

* Java
* Spring MVC
* Hibernate/JPA
* MySQL hoặc SQL Server
* JSP/Servlet
* Bootstrap 5 (tùy chọn)
* Maven

---

## 3. Thiết kế cơ sở dữ liệu

### Bảng CHUYEN_BAY

| Tên cột         | Kiểu dữ liệu             | Mô tả                         |
| --------------- | ------------------------ | ----------------------------- |
| maChuyenBay     | INT (PK, AUTO_INCREMENT) | Mã chuyến bay                 |
| soHieuChuyenBay | VARCHAR(50)              | Số hiệu chuyến bay            |
| ngayGioKhoiHanh | DATETIME                 | Ngày giờ khởi hành            |
| ngayGioDen      | DATETIME                 | Ngày giờ đến                  |
| diemKhoiHanh    | VARCHAR(100)             | Điểm khởi hành                |
| diemDen         | VARCHAR(100)             | Điểm đến                      |
| trangThai       | VARCHAR(50)              | Đúng giờ, Hoãn, Hủy, Đổi lịch |

---

### Bảng HANH_KHACH

| Tên cột     | Kiểu dữ liệu             | Mô tả         |
| ----------- | ------------------------ | ------------- |
| maHanhKhach | INT (PK, AUTO_INCREMENT) | Mã hành khách |
| hoTen       | VARCHAR(100)             | Họ tên        |
| soDienThoai | VARCHAR(10)              | Số điện thoại |
| email       | VARCHAR(100)             | Email         |

---

### Bảng VE_MAY_BAY

| Tên cột     | Kiểu dữ liệu             | Mô tả                           |
| ----------- | ------------------------ | ------------------------------- |
| maVe        | INT (PK, AUTO_INCREMENT) | Mã vé                           |
| maHanhKhach | INT (FK)                 | Hành khách                      |
| maChuyenBay | INT (FK)                 | Chuyến bay                      |
| loaiVe      | VARCHAR(50)              | Hạng phổ thông, Hạng thương gia |
| giaVe       | BIGINT                   | Giá vé                          |
| thongBao    | VARCHAR(255)             | Thông báo                       |

---

### Bảng LICH_SU_CHUYEN_BAY

| Tên cột         | Kiểu dữ liệu             | Mô tả              |
| --------------- | ------------------------ | ------------------ |
| maLichSu        | INT (PK, AUTO_INCREMENT) | Mã lịch sử         |
| maChuyenBay     | INT (FK)                 | Chuyến bay         |
| trangThaiCu     | VARCHAR(50)              | Trạng thái cũ      |
| trangThaiMoi    | VARCHAR(50)              | Trạng thái mới     |
| thoiGianCapNhat | DATETIME                 | Thời gian cập nhật |

### Quan hệ dữ liệu

* Một hành khách có thể đặt nhiều vé.
* Một chuyến bay có thể có nhiều vé.
* Một chuyến bay có nhiều bản ghi lịch sử thay đổi trạng thái.
* Một vé thuộc duy nhất một hành khách và một chuyến bay.

---

## 4. Chức năng hệ thống

### 4.1 Quản lý Chuyến bay

Cho phép thêm mới chuyến bay:

* Số hiệu chuyến bay
* Ngày giờ khởi hành
* Ngày giờ đến
* Điểm khởi hành
* Điểm đến
* Trạng thái chuyến bay

#### Validation

**Ngày giờ đến**

* Phải sau ngày giờ khởi hành.

Ví dụ:

```java
ngayGioDen.isAfter(ngayGioKhoiHanh)
```

#### Danh sách trạng thái

* Đúng giờ
* Hoãn
* Hủy
* Đổi lịch

#### Nghiệp vụ đặc biệt

Khi trạng thái chuyến bay được cập nhật thành:

* Hoãn
* Hủy

Hệ thống phải:

1. Cập nhật giá vé của tất cả vé thuộc chuyến bay đó thành:

```java
0
```

2. Cập nhật thông báo của các vé:

Ví dụ:

```text
Chuyến bay đã bị hoãn
```

hoặc

```text
Chuyến bay đã bị hủy
```

3. Lưu lịch sử thay đổi vào bảng `LICH_SU_CHUYEN_BAY`.

---

### 4.2 Quản lý Hành khách

Cho phép thêm mới hành khách:

* Họ tên
* Số điện thoại
* Email

#### Validation

**Số điện thoại**

* Bắt đầu bằng số 0.
* Gồm đúng 10 chữ số.

Regex:

```java
^0[0-9]{9}$
```

**Email**

Ví dụ:

```java
@Email(message = "Email không hợp lệ")
private String email;
```

---

### 4.3 Quản lý Vé máy bay

Cho phép đặt vé máy bay.

Thông tin gồm:

* Hành khách (ComboBox từ CSDL)
* Chuyến bay (ComboBox từ CSDL)
* Loại vé
* Giá vé
* Thông báo

#### Danh sách Loại vé

* Hạng phổ thông
* Hạng thương gia

#### Validation

**Giá vé**

* Là số nguyên không âm.
* Chia hết cho 1.000.

Ví dụ hợp lệ:

```java
90000
150000
500000
```

Ví dụ kiểm tra:

```java
giaVe >= 0 && giaVe % 1000 == 0
```

---

## 5. Chức năng tìm kiếm

### 5.1 Tìm kiếm Hành khách

Cho phép tìm kiếm:

* Mã hành khách
* Họ tên
* Số điện thoại
* Email

Kết quả hiển thị:

* Mã hành khách
* Họ tên
* Số điện thoại
* Email

---

### 5.2 Tìm kiếm Vé máy bay

Kết quả hiển thị:

* Mã vé
* Số hiệu chuyến bay
* Loại vé
* Giá vé
* Thông báo

Có thể tìm kiếm theo:

* Hành khách
* Số hiệu chuyến bay

---

## 6. Kiến trúc dự án

```text
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

### Framework

* Spring MVC
* Hibernate/JPA

### Mô hình MVC

* Controller xử lý request.
* Service xử lý nghiệp vụ.
* DAO thao tác dữ liệu.
* JSP hiển thị giao diện.

### Cơ sở dữ liệu

* MySQL hoặc SQL Server.

### Coding Convention

* PascalCase cho tên lớp.
* camelCase cho biến.
* Code rõ ràng, dễ đọc.
* Phân tầng đầy đủ Controller - Service - DAO - Entity.

---

## 8. Giao diện

Khuyến khích sử dụng:

* Bootstrap 5
* Responsive Design
* Navbar điều hướng
* Form nhập liệu trực quan
* Bảng dữ liệu đẹp

Điểm cộng tối đa:

* 1.0 điểm

---

## 9. Kết luận

Hệ thống đáp ứng đầy đủ các yêu cầu:

✔ Quản lý Chuyến bay

✔ Quản lý Hành khách

✔ Quản lý Vé máy bay

✔ Quản lý Lịch sử chuyến bay

✔ Validation dữ liệu đầu vào

✔ Tìm kiếm Hành khách

✔ Tìm kiếm Vé máy bay

✔ Tự động cập nhật vé khi chuyến bay bị Hoãn hoặc Hủy

✔ Áp dụng Spring MVC và Hibernate

✔ Tuân thủ Java Coding Convention
