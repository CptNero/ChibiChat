package controller;

import dao.DbSet;
import rest.ChatRoomModel;
import rest.UserModel;

import java.io.IOException;
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
        dbSet.chatRoomDbSet.Create();
        dbSet.messageDbSet.Create();
        dbSet.userDbSet.Create();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nickname = request.getParameter("nickname");
        long chatRoomId = Long.parseLong(request.getParameter("chatroom"));
        UserModel user = dbSet.userDbSet.GetByName(nickname);
        ChatRoomModel chatRoom = dbSet.chatRoomDbSet.GetOneById(chatRoomId);
        HttpSession session = request.getSession();

        if (chatRoom == null){
            session.setAttribute("error", "Chatroom was not found");
            response.sendRedirect("/ChibiChat_war/error");
        }
        if (chatRoomId == 0){
            session.setAttribute("error", "ChatroomId Id was not set");
            response.sendRedirect("/ChibiChat_war/error");
        }
        if (user == null){
            session.setAttribute("error", "User was not found");
            response.sendRedirect("/ChibiChat_war/error");
        }

        session.setAttribute("nickname", user.getNickname());
        session.setAttribute("userId", user.getId());
        session.setAttribute("chatRoomId", chatRoom.getId());

        response.sendRedirect("/ChibiChat_war/chat");
    }
}