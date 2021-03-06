package internet.store.controllers.ordercontroller;

import internet.store.lib.Injector;
import internet.store.service.OrderService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserOrdersController extends HttpServlet {
    private static final String USER_ID = "user_id";
    private static final Injector injector = Injector.getInstance("internet.store");
    private final OrderService orderService = (OrderService) injector
            .getInstance(OrderService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        req.setAttribute("orders", orderService.getUserOrders(userId));
        req.getRequestDispatcher("/WEB-INF/views/user/order.jsp").forward(req, resp);
    }
}
