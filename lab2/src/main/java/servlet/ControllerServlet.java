package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.TableBean;

import java.io.IOException;

@WebServlet(name = "ControllerServlet", value = "/control")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initSession(req);
        if (req.getParameter("coordinateX") != null && req.getParameter("coordinateY") != null
                && req.getParameter("radius") != null) {
            System.out.println("send to area");
            getServletContext().getNamedDispatcher("AreaCheckServlet").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
        }
    }

    protected void initSession(HttpServletRequest req) {
        if (req.getSession().getAttribute("table") == null) {
            req.getSession().setAttribute("table", new TableBean());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}