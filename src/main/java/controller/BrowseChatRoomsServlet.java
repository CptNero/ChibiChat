package controller;

import dao.DbSet;
import rest.ChatRoomModel;
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

@WebServlet("/controller.BrowseChatRoomsServlet")
public class BrowseChatRoomsServlet extends HttpServlet {

    private DbSet dbSet = new DbSet();

    public BrowseChatRoomsServlet() {
    }

    public void init(){
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("category");

        ServletContext context = request.getServletContext();
        List<ChatRoomModel> chatRooms = new LinkedList<>();

        if(!name.equals("") && !category.equals("")){
            chatRooms = dbSet.chatRoomDbSet.GetFilteredByNameAndCategory(name, category);
        }
        else if(!name.equals("")){
            chatRooms = dbSet.chatRoomDbSet.GetFilteredByName(name);
        }
        else if(!category.equals("")){
            chatRooms = dbSet.chatRoomDbSet.GetFilteredByCategory(category);
        }
        else {
            chatRooms = dbSet.chatRoomDbSet.List();
        }

        context.setAttribute("chatRoomsBrowse", chatRooms);
        response.sendRedirect("/ChibiChat_war/browsechatrooms");
    }
}