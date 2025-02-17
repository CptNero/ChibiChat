package controller;

import com.sun.net.httpserver.HttpContext;
import dao.DbSet;
import rest.UserModel;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller.UserServlet")
public class UserServlet extends HttpServlet {

    private DbSet dbSet = new DbSet();

    public UserServlet() {
    }

    public void init(){
        dbSet.userDbSet.Create();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();

        UserModel user = new UserModel(
            request.getParameter("nickName"),
            Integer.parseInt(request.getParameter("age")),
            Boolean.parseBoolean(request.getParameter("sex")),
            request.getParameter("interests")
            );
        dbSet.userDbSet.InsertOrReplace(user);

        List<UserModel> users = dbSet.userDbSet.List();
        context.setAttribute("users", users);
        context.setAttribute("usersBrowse", users);

        response.sendRedirect("/ChibiChat_war");
    }
}