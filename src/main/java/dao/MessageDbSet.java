package dao;

import rest.MessageModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDbSet extends BaseDbSet {

    private Timestamp now;

    public MessageDbSet() {
        super();
        CREATE_STRING = "CREATE TABLE IF NOT EXISTS Messages(" +
                "Id INTEGER PRIMARY KEY," +
                "CreatedOn DATETIME NOT NULL," +
                "ChatRoomId INTEGER NOT NULL," +
                "UserId INTEGER NOT NULL," +
                "Message TEXT NOT NULL," +
                "Image TEXT);";
        DROP_STRING = "DROP TABLE Messages;";
        LIST_STRING = "SELECT * FROM Messages WHERE";
        GET_STRING = "SELECT * FROM Messages WHERE ChatRoomId = ?;";
        INSERT_OR_REPLACE_STRING = "REPLACE INTO Messages(CreatedOn, ChatRoomId, UserId, Message, Image) VALUES(?,?,?,?,?)";
        DELETE_STRING = "DELETE FROM Messages WHERE Id = ?";
        now = new Timestamp(System.currentTimeMillis());
    }

    public void Create() {
        ExecuteQuery(CREATE_STRING);
    }

    public void Drop() {
        ExecuteQuery(DROP_STRING);
    }

    public List<MessageModel> List(){
        try {
            connection = DriverManager.getConnection(DB_STRING);
            Statement statement = connection.createStatement();
            statement.execute(LIST_STRING);

            ResultSet result = statement.getResultSet();

            List<MessageModel> messages = new ArrayList<MessageModel>();

            while(result.next()){
                messages.add(new MessageModel(
                        result.getLong("Id"),
                        result.getTimestamp("CreatedOn"),
                        result.getLong("ChatRoomId"),
                        result.getLong("UserId"),
                        result.getString("Message"),
                        result.getString("Image"))
                );
            }
            connection.close();
            return messages;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public MessageModel GetOne(long id) {
        try{
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING);
            statement.setLong(1, id);
            statement.executeUpdate();
            ResultSet result = statement.getResultSet();

            MessageModel message = new MessageModel(
                    result.getLong("Id"),
                    result.getTimestamp("CreatedOn"),
                    result.getLong("ChatRoomId"),
                    result.getLong("UserId"),
                    result.getString("Message"),
                    result.getString("Image")
            );
            connection.close();
            return message;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    public List<MessageModel> GetMultiple(long id){
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING);
            statement.setLong(1, id);
            statement.execute();
            ResultSet result = statement.getResultSet();

            List<MessageModel> messages = new ArrayList<>();

            while(result.next()){
                messages.add(new MessageModel(
                        result.getLong("Id"),
                        result.getTimestamp("CreatedOn"),
                        result.getLong("ChatRoomId"),
                        result.getLong("UserId"),
                        result.getString("Message"),
                        result.getString("Image"))
                );
            }
            connection.close();
            return messages;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void InsertOrReplace(MessageModel message) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(INSERT_OR_REPLACE_STRING);
            statement.setTimestamp(1, now);
            statement.setLong(2, message.getChatRoomId());
            statement.setLong(3, message.getUserId());
            statement.setString(4, message.getMessage());
            statement.setString(5, message.getImage());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void Delete(MessageDbSet model) {

    }
}
