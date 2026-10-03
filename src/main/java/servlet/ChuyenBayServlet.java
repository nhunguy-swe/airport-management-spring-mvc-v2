package servlet;

import dao.ChuyenBayDao;
import entities.ChuyenBay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/chuyen-bay")
public class ChuyenBayServlet extends HttpServlet {

    private ChuyenBayDao dao = new ChuyenBayDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("listCB", dao.getAllChuyenBay());
        request.getRequestDispatcher("chuyen-bay.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String soHieu = request.getParameter("soHieu");
            String khoiHanh = request.getParameter("khoiHanh");
            String den = request.getParameter("den");
            String diemKhoiHanh = request.getParameter("diemKhoiHanh");
            String diemDen = request.getParameter("diemDen");
            String trangThai = request.getParameter("trangThai");

            ChuyenBay cb = new ChuyenBay();

            cb.setSoHieuChuyenBay(soHieu);
            cb.setNgayGioKhoiHanh(LocalDateTime.parse(khoiHanh));
            cb.setNgayGioDen(LocalDateTime.parse(den));
            cb.setDiemKhoiHanh(diemKhoiHanh);
            cb.setDiemDen(diemDen);
            cb.setTrangThai(trangThai);

            // Logic validation: Ngày đến > Ngày đi
            if(cb.getNgayGioDen().isAfter(cb.getNgayGioKhoiHanh())) {

                dao.insertChuyenBay(cb);
                response.sendRedirect("chuyen-bay");

            } else {

                request.setAttribute("error", "Ngày đến phải sau ngày đi!");
                doGet(request, response);
            }
        } else if ("updateTrangThai".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String status = request.getParameter("status");

            dao.updateTrangThai(id, status); // Trigger MySQL tự chạy để cập nhật vé
            response.sendRedirect("chuyen-bay");
        }
    }
}