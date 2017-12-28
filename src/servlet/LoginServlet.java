package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.UserInfo;

public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserInfo u = new UserInfo();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        u.setUsername(username);
        u.setPassword(password);

        // 判断用户名和密码是否合法
        if (u.getUsername().equals("admin") && u.getPassword().equals("admin")) {

            resp.sendRedirect(req.getContextPath() + "/login_success.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login_failure.jsp");
            }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
