package internet.store.controllers;

import internet.store.lib.Injector;
import internet.store.model.User;
import internet.store.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("internet.store");
    UserService userService = (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String userName = req.getParameter("userName");
        String password = req.getParameter("pwd");
        String repeatPassword = req.getParameter("pwd-repeat");

        if (password.equals(repeatPassword)) {
            userService.create(new User(userName, login, password));
            //           for (User u: Storage.users) {
            //               System.out.println(u.toString());
            //           }
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("message", "Your repeat password is not the same with password");
            req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
        }
    }
}
