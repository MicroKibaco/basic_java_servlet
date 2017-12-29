package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

public class CartServlet extends HttpServlet {
    private String action; // 表示action的动作, add , show , delete
    private ItemsDAO idao = new ItemsDAO(); // 商品业务逻辑的对象

    public CartServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (req.getParameter("action") != null) {
            this.action = req.getParameter("action");
            if (action.equals("add")) { // 如果是添加商品进购物车
                if (addToCart(req, resp)) {
                    req.getRequestDispatcher("/success.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/failure.jsp").forward(req, resp);

                }
            }

            if (action.equals("show")) { // 如果显示购物车
                req.getRequestDispatcher("/cart.jsp").forward(req, resp);
            }
        }

    }

    /**
     * 显示购物车
     */

    private boolean showCart(HttpServletRequest req, HttpServletResponse resp) {

        return false;
    }

    /**
     * 添加购物车
     */

    private boolean addToCart(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String num = req.getParameter("num");
        Items item = idao.getItemsById(Integer.parseInt(id));

        // 是否是第一次给购物车添加商品,需要给session中创建一个新的购物车对象
        if (req.getSession().getAttribute("cart") != null) {
            Cart cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart.addGoodsInCart(item, Integer.parseInt(num))) {
            return true;
        } else {
            return false;
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
