package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetInitParameterServlet extends HttpServlet {

    private String username; // 用户名
    private String password; // 密码

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h2>"+"用户名: "+this.getUsername()+"</h2>");
        out.println("<h2>"+"密码: "+this.getPassword()+"</h2>");

    }

    @Override
    public void init() throws ServletException {
        // put your code here
        this.setUsername(this.getInitParameter("username"));
        this.setPassword(this.getInitParameter("password"));
    }
}
