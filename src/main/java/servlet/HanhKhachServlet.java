package servlet;

import dao.HanhKhachDao;

import entities.HanhKhach;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/hanh-khach")
public class HanhKhachServlet extends HttpServlet {

    private HanhKhachDao dao = new HanhKhachDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        List<HanhKhach> list;

        if (keyword != null && !keyword.isEmpty()) {

            list = dao.searchHanhKhach(keyword);
        } else {

            list = dao.getAllHanhKhach();
        }

        request.setAttribute("listHK", list);

        request.getRequestDispatcher("hanh-khach.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String hoTen = request.getParameter("hoTen");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        HanhKhach hk = new HanhKhach();

        hk.setHoTen(hoTen);
        hk.setSoDienThoai(soDienThoai);
        hk.setEmail(email);

        // Regex kiểm tra SĐT: 10 số, bắt đầu bằng 0
        if (hk.getSoDienThoai() != null && hk.getSoDienThoai().matches("^0[0-9]{9}$")) {

            dao.insertHanhKhach(hk);
            response.sendRedirect("hanh-khach");
        } else {

            request.setAttribute("error", "SĐT không hợp lệ (phải có 10 số và bắt đầu bằng 0)!");
            request.setAttribute("listHK", dao.getAllHanhKhach());
            request.getRequestDispatcher("hanh-khach.jsp").forward(request, response);
        }
    }
}