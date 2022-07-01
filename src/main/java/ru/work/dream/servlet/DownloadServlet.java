package ru.work.dream.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        File users = null;
        for (File file : new File("c:\\projects\\work_dreamjob\\images\\").listFiles()) {
            int pos = file.getName().lastIndexOf(".");
            String justName = pos > 0 ? file.getName().substring(0, pos) : file.getName();
            if (name.equals(justName)) {
                users = file;
                break;
            }
        }
        try (FileInputStream stream = new FileInputStream(users)){
            resp.getOutputStream().write(stream.readAllBytes());
        }

    }

}
