package dao;

public class DbSet {
    public UserDbSet userDbSet;

    public ChatRoomDbSet chatRoomDbSet;

    public MessageDbSet messageDbSet;

    public DbSet() {
        this.userDbSet = new UserDbSet();
        this.chatRoomDbSet = new ChatRoomDbSet();
        this.messageDbSet = new MessageDbSet();
    }
}
