package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;

public class RegServlet extends HttpServlet {
    public RegServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Users u = new Users();
        String username;
        String mypassword;
        String email;
        String gender;
        Date birthday;
        String[] favorites;
        String introduce;
        boolean isAccept;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            username = req.getParameter("username");
            mypassword = req.getParameter("mypassword");
            email = req.getParameter("email");
            gender = req.getParameter("gender");
            introduce = req.getParameter("introduce");
            birthday = sdf.parse(req.getParameter("birthday"));
            favorites = req.getParameterValues("favorite");// 用来获取多个复选按钮的值
            isAccept = "true".equals(req.getParameter("flag")) ? true : false;

            u.setUsername(username);
            u.setMypassword(mypassword);
            u.setEmail(email);
            u.setGender(gender);
            u.setIntroduce(introduce);
            u.setBirthday(birthday);
            u.setFavorites(favorites);
            u.setFlag(isAccept);
            // 把注册成功的用户对象保存在session中
            req.getSession().setAttribute("regUser", u);
            // 跳转到注册成功的页面
            req.getRequestDispatcher("../userinfo.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
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
