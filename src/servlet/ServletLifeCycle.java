package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle extends HttpServlet {
    public ServletLifeCycle() {
        System.out.println("ServletLifeCycle的构造方法被执行了....");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletLifeCycle的doGet()方法被执行了....");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        out.print("<br><strong>您好,我是ServletLifeCycle </strong></br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletLifeCycle的doPost()方法被执行了....");
        doGet(req, resp); // 让doPost()执行与doGet()相同的操作
    }

    @Override
    public void destroy() {
        System.out.println("ServletLifeCycle的销毁方法被执行了....");

    }

    @Override
    public void init() throws ServletException {
        System.out.println("ServletLifeCycle初始化方法被执行了...");
    }
}
