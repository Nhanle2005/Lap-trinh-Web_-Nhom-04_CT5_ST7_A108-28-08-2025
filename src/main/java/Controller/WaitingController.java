package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import model.User;

@WebServlet("/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("account") != null) {
            User user = (User) session.getAttribute("account");
            if(user.getRoleid() == 1) {
                resp.sendRedirect(req.getContextPath() + "/admin/home.jsp");
            } else if(user.getRoleid() == 2) {
                resp.sendRedirect(req.getContextPath() + "/manager/home.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/home.jsp");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
