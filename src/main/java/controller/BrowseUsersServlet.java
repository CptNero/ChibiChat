package controller;

import dao.DbSet;
import rest.UserModel;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller.BrowseUsersServlet")
public class BrowseUsersServlet extends HttpServlet {

    private DbSet dbSet = new DbSet();

    public BrowseUsersServlet() {
    }

    public void init(){
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String interest = request.getParameter("interest");

        ServletContext context = request.getServletContext();
        List<UserModel> users = new LinkedList<>();

        if(!name.equals("") && !interest.equals("")){
            users = dbSet.userDbSet.GetFilteredByNameAndInterest(name, interest);
        }
        else if(!name.equals("")){
            users = dbSet.userDbSet.GetFilteredByName(name);
        }
        else if(!interest.equals("")){
            users = dbSet.userDbSet.GetFilteredByInterest(interest);
        }
        else {
            users = dbSet.userDbSet.List();
        }

        context.setAttribute("usersBrowse", users);
        response.sendRedirect("/ChibiChat_war/browseusers");
    }
}