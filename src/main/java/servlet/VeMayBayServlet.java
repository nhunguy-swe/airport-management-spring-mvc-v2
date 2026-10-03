package servlet;

import dao.ChuyenBayDao;
import dao.HanhKhachDao;
import dao.VeMayBayDao;

import entities.VeMayBay;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ve-may-bay")
public class VeMayBayServlet extends HttpServlet {

    private VeMayBayDao veMayBayDao = new VeMayBayDao();
    private ChuyenBayDao chuyenBayDao = new ChuyenBayDao();
    private HanhKhachDao hanhKhachDao = new HanhKhachDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        request.setAttribute("listCB", chuyenBayDao.getAllChuyenBay());
        request.setAttribute("listHK", hanhKhachDao.getAllHanhKhach());

        // Logic hiển thị bảng vé
        if (keyword != null && !keyword.isEmpty()) {
            request.setAttribute("listVe", veMayBayDao.searchVe(keyword));
        } else {
            request.setAttribute("listVe", veMayBayDao.getAllVe());
        }

        request.getRequestDispatcher("ve-may-bay.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            int maHanhKhach = Integer.parseInt(request.getParameter("maHK"));
            int maChuyenBay = Integer.parseInt(request.getParameter("maCB"));
            String loaiVe = request.getParameter("loaiVe");
            int giaVe = Integer.parseInt(request.getParameter("giaVe"));
            String thongBao = request.getParameter("thongBao");

            VeMayBay v = new VeMayBay();

            v.setMaHanhKhach(maHanhKhach);
            v.setMaChuyenBay(maChuyenBay);
            v.setLoaiVe(loaiVe);
            v.setGiaVe(giaVe);
            v.setThongBao(thongBao);

            String giaStr = request.getParameter("giaVe");
            int gia = (giaStr != null && !giaStr.isEmpty()) ? Integer.parseInt(giaStr) : 0;

            // Kiểm tra giá vé không âm và chia hết cho 1000
            if (gia >= 0 && gia % 1000 == 0) {

                veMayBayDao.insertVe(v);
                response.sendRedirect("ve-may-bay");
            } else {

                request.setAttribute("error", "Giá vé phải >= 0 và chia hết cho 1000!");
                doGet(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ve-may-bay");
        }
    }
}