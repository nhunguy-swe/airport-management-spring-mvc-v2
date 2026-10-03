package dao;

import entities.VeMayBay;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeMayBayDao {

    public List<VeMayBay> getAllVe() {

        List<VeMayBay> list = new ArrayList<>();
        String sql = "SELECT v.*, c.so_hieu_chuyen_bay, h.ho_ten " +
                "FROM ve_may_bay v " +
                "JOIN chuyen_bay c ON v.ma_chuyen_bay = c.ma_chuyen_bay " +
                "JOIN hanh_khach h ON v.ma_hanh_khach = h.ma_hanh_khach";

        try (Connection conn = DBUtils.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                VeMayBay v = new VeMayBay();

                v.setMaVe(rs.getInt("ma_ve"));
                v.setMaHanhKhach(rs.getInt("ma_hanh_khach"));
                v.setMaChuyenBay(rs.getInt("ma_chuyen_bay"));
                v.setLoaiVe(rs.getString("loai_ve"));
                v.setGiaVe(rs.getInt("gia_ve"));
                v.setThongBao(rs.getString("thong_bao"));

                v.setSoHieuChuyenBay(rs.getString("so_hieu_chuyen_bay"));
                v.setTenHanhKhach(rs.getString("ho_ten"));

                list.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insertVe(VeMayBay v) {

        String sql = "INSERT INTO ve_may_bay(ma_hanh_khach,ma_chuyen_bay,loai_ve,gia_ve,thong_bao) VALUES(?,?,?,?,?)";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, v.getMaHanhKhach());
            ps.setInt(2, v.getMaChuyenBay());
            ps.setString(3, v.getLoaiVe());
            ps.setInt(4, v.getGiaVe());
            ps.setString(5, v.getThongBao());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<VeMayBay> searchVe(String keyword) {

        List<VeMayBay> list = new ArrayList<>();
        String sql = "SELECT v.*, c.so_hieu_chuyen_bay, h.ho_ten " +
                "FROM ve_may_bay v " +
                "JOIN chuyen_bay c ON v.ma_chuyen_bay = c.ma_chuyen_bay " +
                "JOIN hanh_khach h ON v.ma_hanh_khach = h.ma_hanh_khach " +
                "WHERE c.so_hieu_chuyen_bay LIKE ? OR h.ho_ten LIKE ?";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                VeMayBay v = new VeMayBay();

                v.setMaVe(rs.getInt("ma_ve"));
                v.setSoHieuChuyenBay(rs.getString("so_hieu_chuyen_bay"));
                v.setTenHanhKhach(rs.getString("ho_ten"));
                v.setLoaiVe(rs.getString("loai_ve"));
                v.setGiaVe(rs.getInt("gia_ve"));
                v.setThongBao(rs.getString("thong_bao"));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}