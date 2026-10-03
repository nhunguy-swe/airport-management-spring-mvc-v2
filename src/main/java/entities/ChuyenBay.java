package entities;

import java.time.LocalDateTime;

public class ChuyenBay {

    private int maChuyenBay;
    private String soHieuChuyenBay;
    private LocalDateTime ngayGioKhoiHanh;
    private LocalDateTime ngayGioDen;
    private String diemKhoiHanh;
    private String diemDen;
    private String trangThai; // Đúng giờ, Hoãn, Hủy, Đổi lịch, Đã bay

    public ChuyenBay() {
    }

    public ChuyenBay(int maChuyenBay, String soHieuChuyenBay, LocalDateTime ngayGioKhoiHanh,
                     LocalDateTime ngayGioDen, String diemKhoiHanh, String diemDen, String trangThai) {
        this.maChuyenBay = maChuyenBay;
        this.soHieuChuyenBay = soHieuChuyenBay;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
        this.ngayGioDen = ngayGioDen;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
        this.trangThai = trangThai;
    }

    public int getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(int maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getSoHieuChuyenBay() {
        return soHieuChuyenBay;
    }

    public void setSoHieuChuyenBay(String soHieuChuyenBay) {
        this.soHieuChuyenBay = soHieuChuyenBay;
    }

    public LocalDateTime getNgayGioKhoiHanh() {
        return ngayGioKhoiHanh;
    }

    public void setNgayGioKhoiHanh(LocalDateTime ngayGioKhoiHanh) {
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
    }

    public LocalDateTime getNgayGioDen() {
        return ngayGioDen;
    }

    public void setNgayGioDen(LocalDateTime ngayGioDen) {
        this.ngayGioDen = ngayGioDen;
    }

    public String getDiemKhoiHanh() {
        return diemKhoiHanh;
    }

    public void setDiemKhoiHanh(String diemKhoiHanh) {
        this.diemKhoiHanh = diemKhoiHanh;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}