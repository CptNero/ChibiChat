package controller;

import dao.DbSet;
import rest.ChatRoomModel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller.ChatRoomServlet")
public class ChatRoomServlet extends HttpServlet {

    private DbSet dbSet = new DbSet();

    public ChatRoomServlet() {
    }

    public void init(){
        dbSet.chatRoomDbSet.Create();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChatRoomModel chatRoom = new ChatRoomModel(
            request.getParameter("name"),
            request.getParameter("rules"),
            request.getParameter("category")
        );
        dbSet.chatRoomDbSet.InsertOrReplace(chatRoom);
        response.sendRedirect("/ChibiChat_war");
    }
}