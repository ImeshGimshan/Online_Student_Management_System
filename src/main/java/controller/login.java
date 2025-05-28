package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.DBConfig;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (Connection con = DBConfig.getConnection()){
            String sql = "select * from users where username = ? and password = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", rs.getString("role"));
                if("admin".equals(rs.getString("role"))){
                    res.sendRedirect("jsp/admin/dashboard.jsp");
                }
                else {
                    res.sendRedirect("jsp/student/studentPanel.jsp");
                }

            }
            else {
                req.setAttribute("error", "Invalid username or password");
                req.getRequestDispatcher("jsp/unauthorized.jsp").forward(req, res);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("jsp/error.jsp");
        }
    }
}
