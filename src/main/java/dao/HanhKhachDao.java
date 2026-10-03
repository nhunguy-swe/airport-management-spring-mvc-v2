package dao;

import entities.HanhKhach;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HanhKhachDao {

    public List<HanhKhach> getAllHanhKhach() {

        List<HanhKhach> list = new ArrayList<>();
        String sql = "SELECT * FROM hanh_khach";

        try (Connection conn = DBUtils.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                HanhKhach hk = new HanhKhach();

                hk.setMaHanhKhach(rs.getInt("ma_hanh_khach"));
                hk.setHoTen(rs.getString("ho_ten"));
                hk.setSoDienThoai(rs.getString("so_dien_thoai"));
                hk.setEmail(rs.getString("email"));

                list.add(hk);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insertHanhKhach(HanhKhach hk) {

        String sql = "INSERT INTO hanh_khach(ho_ten,so_dien_thoai,email) VALUES(?,?,?)";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hk.getHoTen());
            ps.setString(2, hk.getSoDienThoai());
            ps.setString(3, hk.getEmail());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HanhKhach> searchHanhKhach(String keyword) {

        List<HanhKhach> list = new ArrayList<>();
        String sql = "SELECT * FROM hanh_khach WHERE ho_ten LIKE ? OR so_dien_thoai LIKE ?";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                HanhKhach hk = new HanhKhach();

                hk.setMaHanhKhach(rs.getInt("ma_hanh_khach"));
                hk.setHoTen(rs.getString("ho_ten"));
                hk.setSoDienThoai(rs.getString("so_dien_thoai"));
                hk.setEmail(rs.getString("email"));

                list.add(hk);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}