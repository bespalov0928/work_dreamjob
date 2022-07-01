package ru.work.dream.servlet;

import ru.work.dream.model.Candidate;
import ru.work.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidatesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        System.out.println("city: "+ req.getParameter("city"));
//        System.out.println("name: "+ req.getParameter("name"));
        PsqlStore.instOf().addCandidates(
                new Candidate(
                        Integer.valueOf(req.getParameter("id")),
                        req.getParameter("name"),
                        req.getParameter("city")

                )
        );
        req.setAttribute("user", req.getSession().getAttribute("user"));
        resp.sendRedirect(req.getContextPath() + "/candidate.do");
    }

}
