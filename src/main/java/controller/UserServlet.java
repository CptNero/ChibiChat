package controller;

import dao.DbSet;
import rest.UserModel;

import java.io.IOException;
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
        UserModel user = new UserModel(
            request.getParameter("nickName"),
            Integer.parseInt(request.getParameter("age")),
            Boolean.parseBoolean(request.getParameter("sex")),
            request.getParameter("interests")
            );
        dbSet.userDbSet.InsertOrReplace(user);
        response.sendRedirect("/ChibiChat_war");
    }
}