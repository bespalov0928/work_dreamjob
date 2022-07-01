package ru.work.dream.servlet;

import ru.work.dream.model.User;
import ru.work.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        HttpSession hs = req.getSession();
        //User userStart = new User(0, name, email, password);
        User user = PsqlStore.instOf().findUserByEmail(email);
        if (user != null){
            hs.setAttribute("user", user);

            resp.sendRedirect(req.getContextPath() + "/reg.do");
            return;
        }
        user = PsqlStore.instOf().addUser(0, name, email, password);
//        hs.setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/index.do");
    }

}
