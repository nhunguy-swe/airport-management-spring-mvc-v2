package dao;

import entities.ChuyenBay;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChuyenBayDao {

    public List<ChuyenBay> getAllChuyenBay() {

        List<ChuyenBay> list = new ArrayList<>();
        String sql = "SELECT * FROM chuyen_bay";

        try (Connection conn = DBUtils.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                ChuyenBay cb = new ChuyenBay();

                cb.setMaChuyenBay(rs.getInt("ma_chuyen_bay"));
                cb.setSoHieuChuyenBay(rs.getString("so_hieu_chuyen_bay"));
                cb.setNgayGioKhoiHanh(rs.getTimestamp("ngay_gio_khoi_hanh").toLocalDateTime());
                cb.setNgayGioDen(rs.getTimestamp("ngay_gio_den").toLocalDateTime());
                cb.setDiemKhoiHanh(rs.getString("diem_khoi_hanh"));
                cb.setDiemDen(rs.getString("diem_den"));
                cb.setTrangThai(rs.getString("trang_thai"));

                list.add(cb);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insertChuyenBay(ChuyenBay cb) {

        String sql = "INSERT INTO chuyen_bay(so_hieu_chuyen_bay,ngay_gio_khoi_hanh,ngay_gio_den,diem_khoi_hanh,diem_den,trang_thai) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cb.getSoHieuChuyenBay());
            ps.setTimestamp(2, Timestamp.valueOf(cb.getNgayGioKhoiHanh()));
            ps.setTimestamp(3, Timestamp.valueOf(cb.getNgayGioDen()));
            ps.setString(4, cb.getDiemKhoiHanh());
            ps.setString(5, cb.getDiemDen());
            ps.setString(6, cb.getTrangThai());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTrangThai(int id, String status) {

        String sql = "UPDATE chuyen_bay SET trang_thai = ? WHERE ma_chuyen_bay = ?";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}