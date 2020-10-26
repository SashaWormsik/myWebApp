package by.sasha.myWebApp;

import by.sasha.myWebApp.service.User;
import by.sasha.myWebApp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        User user = UserService.getService().getUsers().get(Integer.parseInt(parameter));
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/jstl3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            UserService.getService().editUser(Integer.parseInt(req.getParameter("number")),
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    new SimpleDateFormat("yyy-MM-dd")
                            .parse(req.getParameter("birthdate")),
                    Boolean.parseBoolean(req.getParameter("male")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/myWebApp/jstl1");
    }
}
