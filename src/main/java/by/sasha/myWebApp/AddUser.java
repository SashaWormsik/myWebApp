package by.sasha.myWebApp;

import by.sasha.myWebApp.service.User;
import by.sasha.myWebApp.service.UserService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserService.getService()
                    .addUser(
                            new User(null,
                                    req.getParameter("firstName"),
                                    req.getParameter("lastName"),
                                    new SimpleDateFormat("yyy-MM-dd")
                                            .parse(req.getParameter("birthdate")),
                                    Boolean.valueOf(req.getParameter("male"))));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/myWebApp/jstl1");
    }
}
