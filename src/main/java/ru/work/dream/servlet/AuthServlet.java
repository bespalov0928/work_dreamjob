package ru.work.dream.servlet;

import ru.work.dream.model.User;
import ru.work.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pasword = req.getParameter("password");
        User admin = PsqlStore.instOf().findUserByEmail(email);
        if (admin != null && admin.getPassword().equals(pasword)) {
            HttpSession sc = req.getSession();
            sc.setAttribute("user", admin);
            resp.sendRedirect(req.getContextPath() + "/index.do");
        } else{
            req.setAttribute("error", "Не верный email или пароль");
            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }
    }

}
