package by.sasha.myWebApp;

import by.sasha.myWebApp.service.User;
import by.sasha.myWebApp.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String param = req.getParameter("number");
        User user = UserService.getService().getUserForEdit(Integer.valueOf(param));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        try {
            user.setBirthdate(new SimpleDateFormat("yyy-MM-dd").parse(req.getParameter("birthdate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setMale(Boolean.valueOf(req.getParameter("male")));
        UserService.getService().updateUser(user);
        resp.sendRedirect("/myWebApp/jstl1");
    }
}
