package controller;

import com.sun.net.httpserver.HttpContext;
import dao.DbSet;
import rest.ChatRoomModel;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        ServletContext context = request.getServletContext();

        ChatRoomModel chatRoom = new ChatRoomModel(
            request.getParameter("name"),
            request.getParameter("category"),
            request.getParameter("rules")
        );
        dbSet.chatRoomDbSet.InsertOrReplace(chatRoom);

        List<ChatRoomModel> chatRooms = dbSet.chatRoomDbSet.List();
        context.setAttribute("chatrooms", chatRooms);
        context.setAttribute("chatroomsBrowse", chatRooms);

        response.sendRedirect("/ChibiChat_war");
    }
}