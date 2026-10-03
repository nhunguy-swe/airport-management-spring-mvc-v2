package entities;

public class HanhKhach {

    private int maHanhKhach;
    private String hoTen;
    private String soDienThoai;
    private String email;

    public HanhKhach() {
    }

    public HanhKhach(int maHanhKhach, String hoTen, String soDienThoai, String email) {
        this.maHanhKhach = maHanhKhach;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public int getMaHanhKhach() {
        return maHanhKhach;
    }

    public void setMaHanhKhach(int maHanhKhach) {
        this.maHanhKhach = maHanhKhach;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}