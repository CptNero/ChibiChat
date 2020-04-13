package rest;

import java.sql.Timestamp;

public class MessageModel extends BaseModel {

    private long ChatRoomId;

    private long UserId;

    private String Message;

    private String Image;

    public MessageModel(long chatRoomId, long userId, String message, String image) {
        ChatRoomId = chatRoomId;
        UserId = userId;
        Message = message;
        Image = image;
    }

    public MessageModel(long id, Timestamp createdOn, long chatRoomId, long userId, String message, String image) {
        super(id, createdOn);
        ChatRoomId = chatRoomId;
        UserId = userId;
        Message = message;
        Image = image;
    }

    public long getChatRoomId() { return ChatRoomId; }

    public void setChatRoomId(long chatRoomId) { ChatRoomId = chatRoomId; }

    public long getUserId() { return UserId; }

    public void setUserId(long userId) { UserId = userId; }

    public String getMessage() { return Message; }

    public void setMessage(String message) { Message = message; }

    public String getImage() { return Image; }

    public void setImage(String image) { Image = image; }
}
