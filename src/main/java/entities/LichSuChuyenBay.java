package entities;

import java.sql.Timestamp;

public class LichSuChuyenBay {

    private int maLichSu;
    private int maChuyenBay;
    private String trangThaiCu;
    private String trangThaiMoi;
    private Timestamp thoiGianThayDoi;
    private String ghiChu;

    public LichSuChuyenBay() {
    }

    public LichSuChuyenBay(int maLichSu, int maChuyenBay, String trangThaiCu,
                           String trangThaiMoi, Timestamp thoiGianThayDoi, String ghiChu) {
        this.maLichSu = maLichSu;
        this.maChuyenBay = maChuyenBay;
        this.trangThaiCu = trangThaiCu;
        this.trangThaiMoi = trangThaiMoi;
        this.thoiGianThayDoi = thoiGianThayDoi;
        this.ghiChu = ghiChu;
    }

    public int getMaLichSu() {
        return maLichSu;
    }

    public void setMaLichSu(int maLichSu) {
        this.maLichSu = maLichSu;
    }

    public int getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(int maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getTrangThaiCu() {
        return trangThaiCu;
    }

    public void setTrangThaiCu(String trangThaiCu) {
        this.trangThaiCu = trangThaiCu;
    }

    public String getTrangThaiMoi() {
        return trangThaiMoi;
    }

    public void setTrangThaiMoi(String trangThaiMoi) {
        this.trangThaiMoi = trangThaiMoi;
    }

    public Timestamp getThoiGianThayDoi() {
        return thoiGianThayDoi;
    }

    public void setThoiGianThayDoi(Timestamp thoiGianThayDoi) {
        this.thoiGianThayDoi = thoiGianThayDoi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}