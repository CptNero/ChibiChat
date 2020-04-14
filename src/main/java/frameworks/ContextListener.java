package frameworks;

import dao.DbSet;
import rest.ChatRoomModel;
import rest.UserModel;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext context = arg0.getServletContext();
        DbSet dbSet = new DbSet();

        dbSet.chatRoomDbSet.Create();
        dbSet.messageDbSet.Create();
        dbSet.userDbSet.Create();

        List<ChatRoomModel> chatRooms = dbSet.chatRoomDbSet.List();
        List<UserModel> users = dbSet.userDbSet.List();

        context.setAttribute("users", users);
        context.setAttribute("usersBrowse", users);
        context.setAttribute("chatrooms", chatRooms);
        context.setAttribute("chatRoomsBrowse", chatRooms);
        System.out.println("ServletContextListener started");
    }
}
