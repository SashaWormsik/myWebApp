package by.sasha.myWebApp;

import by.sasha.myWebApp.service.User;
import by.sasha.myWebApp.service.UserService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class InitialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = UserService.getService().getUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/jstl1.jsp").forward(req, resp);
    }

}
