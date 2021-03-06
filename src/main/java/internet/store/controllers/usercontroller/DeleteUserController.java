package internet.store.controllers.usercontroller;

import internet.store.lib.Injector;
import internet.store.service.ShoppingCartService;
import internet.store.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("internet.store");
    private final UserService userService = (UserService) injector
            .getInstance(UserService.class);
    private final ShoppingCartService shoppingCartService = (ShoppingCartService) injector
            .getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = Long.valueOf(req.getParameter("id"));
        shoppingCartService.delete(shoppingCartService.getByUserId(userId));
        userService.delete(userId);
        resp.sendRedirect(req.getContextPath() + "/user/all");
    }
}
