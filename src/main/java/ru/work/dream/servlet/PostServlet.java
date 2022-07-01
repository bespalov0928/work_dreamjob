package ru.work.dream.servlet;

import ru.work.dream.model.Post;
import ru.work.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", PsqlStore.instOf().findAllPosts());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Post post = new Post(id, name);
        PsqlStore.instOf().save(post);
//        if (id == 0){
//            PsqlStore.instOf().save(post);
//        }else {
//            PsqlStore.instOf().update(post);
//        }
//        PsqlStore.instOf().save(
//                new Post(
//                        0,
//                        req.getParameter("name"))
//        );
        resp.sendRedirect(req.getContextPath()+"/post.do");
    }
}
