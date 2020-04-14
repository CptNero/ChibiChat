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

@WebServlet("/controller.ChatServlet")
public class ChatServlet extends HttpServlet {

    private DbSet dbSet = new DbSet();

    public ChatServlet() {
    }

    public void init(){
        dbSet.chatRoomDbSet.Create();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        long chatRoomId = (long)session.getAttribute("chatRoomId");
        UserModel user = dbSet.userDbSet.GetById((long)session.getAttribute("userId"));

        MessageModel message = new MessageModel(
            chatRoomId,
            user.getId(),
            user.getNickname(),
            request.getParameter("message"),
            request.getParameter("image")
        );

        dbSet.messageDbSet.InsertOrReplace(message);

        List<MessageModel> messages = dbSet.messageDbSet.GetMultiple(chatRoomId);
        session.setAttribute("messageList", messages);

        response.sendRedirect("/ChibiChat_war/chat");
    }
}