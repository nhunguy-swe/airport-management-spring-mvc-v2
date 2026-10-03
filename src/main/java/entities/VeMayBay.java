package entities;

public class VeMayBay {

    private int maVe;
    private int maHanhKhach;
    private int maChuyenBay;
    private String loaiVe;
    private int giaVe;
    private String thongBao;

    private String tenHanhKhach;
    private String soHieuChuyenBay;

    public VeMayBay() {
    }

    public VeMayBay(int maVe, int maHanhKhach, int maChuyenBay,
                    String loaiVe, int giaVe, String thongBao) {
        this.maVe = maVe;
        this.maHanhKhach = maHanhKhach;
        this.maChuyenBay = maChuyenBay;
        this.loaiVe = loaiVe;
        this.giaVe = giaVe;
        this.thongBao = thongBao;
    }

    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    public int getMaHanhKhach() {
        return maHanhKhach;
    }

    public void setMaHanhKhach(int maHanhKhach) {
        this.maHanhKhach = maHanhKhach;
    }

    public int getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(int maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    public String getThongBao() {
        return thongBao;
    }

    public void setThongBao(String thongBao) {
        this.thongBao = thongBao;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public String getSoHieuChuyenBay() {
        return soHieuChuyenBay;
    }

    public void setSoHieuChuyenBay(String soHieuChuyenBay) {
        this.soHieuChuyenBay = soHieuChuyenBay;
    }
}