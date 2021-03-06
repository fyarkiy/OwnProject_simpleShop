package internet.store.controllers.ordercontroller;

import internet.store.lib.Injector;
import internet.store.service.OrderService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetOrderController extends HttpServlet {
    private static final Injector injector = Injector
            .getInstance("internet.store");
    private final OrderService orderService = (OrderService) injector
            .getInstance(OrderService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long orderId = Long.valueOf(req.getParameter("orderId"));
        req.setAttribute("products", orderService.get(orderId).getProducts());
        req.getRequestDispatcher("/WEB-INF/views/order/product.jsp").forward(req, resp);
    }
}
