package internet.store.controllers.shoppingcartcontroller;

import internet.store.lib.Injector;
import internet.store.service.ShoppingCartService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageShoppingCartController extends HttpServlet {
    private static final String USER_ID = "user_id";
    private static final Injector injector = Injector
            .getInstance("internet.store");
    private final ShoppingCartService shoppingCartService = (ShoppingCartService) injector
            .getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        req.setAttribute("products", shoppingCartService
                .getByUserId(userId).getProducts());
        req.getRequestDispatcher("/WEB-INF/views/shopping-cart/product.jsp")
                .forward(req, resp);
    }
}
