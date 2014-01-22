package me.christopherdavis.webapptut;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="hellohtml", urlPatterns={"/hellohtml", "/hellohtml/*"})
public class HelloHtml extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("name");
        if (null == name) {
            name = "You";
        }

        resp.setHeader("Content-Type", "text/html");
        resp.getWriter().format("<h1>Hello, %s</h1>", name);
    }
}
