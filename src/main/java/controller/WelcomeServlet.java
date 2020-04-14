package controller;

import dao.DbSet;
import rest.ChatRoomModel;
import rest.MessageModel;
import rest.UserModel;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controller.WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

    private DbSet dbSet = new DbSet();

    @Override
    public void init() throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ChatRoomModel> chatRooms = dbSet.chatRoomDbSet.List();
        session.setAttribute("chatrooms", chatRooms);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nickname = request.getParameter("nickname");
        long chatRoomId = Long.parseLong(request.getParameter("chatroom"));
        UserModel user = dbSet.userDbSet.GetByName(nickname);
        ChatRoomModel chatRoom = dbSet.chatRoomDbSet.GetOneById(chatRoomId);
        HttpSession session = request.getSession();
        List<MessageModel> messages = dbSet.messageDbSet.GetMultiple(chatRoomId);

        if (chatRoom == null){
            session.setAttribute("error", "Chatroom was not found");
            response.sendRedirect("/ChibiChat_war/error");
            return;
        }
        if (chatRoomId == 0){
            session.setAttribute("error", "ChatroomId Id was not set");
            response.sendRedirect("/ChibiChat_war/error");
            return;
        }
        if (user == null){
            session.setAttribute("error", "User was not found");
            response.sendRedirect("/ChibiChat_war/error");
            return;
        }

        session.setAttribute("chatroomname", chatRoom.getName());
        session.setAttribute("chatroomcategory", chatRoom.getCategory());
        session.setAttribute("chatroomrules", chatRoom.getRules());
        session.setAttribute("nickname", user.getNickname());
        session.setAttribute("userId", user.getId());
        session.setAttribute("chatRoomId", chatRoom.getId());

        session.setAttribute("messageList", messages);

        response.sendRedirect("/ChibiChat_war/chat");
    }
}