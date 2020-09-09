package internet.store.controllers.shopcartcontroller;

import internet.store.lib.Injector;
import internet.store.model.ShoppingCart;
import internet.store.service.ProductService;
import internet.store.service.ShoppingCartService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopCartAddProduct extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static final Injector injector = Injector.getInstance("internet.store");
    private final ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private final ProductService productService = (ProductService) injector
            .getInstance(ProductService.class);
    private ShoppingCart shoppingCart = shoppingCartService.create(new ShoppingCart(USER_ID));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        shoppingCartService.addProduct(shoppingCart,
                productService.get(Long.valueOf(req.getParameter("productId"))));
        resp.sendRedirect(req.getContextPath() + "/product/allProduct");
    }
}
