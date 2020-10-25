package by.sasha.myWebApp;

import by.sasha.myWebApp.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        UserService.getService().deleteUser(Integer.valueOf(parameter));
        resp.sendRedirect("/myWebApp/jstl1");
    }
}