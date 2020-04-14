package controller;

import dao.DbSet;
import rest.MessageModel;
import rest.UserModel;

import java.io.IOException;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller.MessageServlet")
public class MessageServlet extends HttpServlet {

    private DbSet dbSet = new DbSet();

    public MessageServlet() {
    }

    public void init(){
        dbSet.messageDbSet.Create();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}