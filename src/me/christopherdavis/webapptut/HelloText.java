package me.christopherdavis.webapptut;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloText extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("name");
        if (null == name) {
            name = "You";
        }

        resp.setHeader("Content-Type", "text/plain");
        resp.getWriter().format("Hello, %s", name);
    }
}
