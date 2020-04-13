package dao;

import rest.ChatRoomModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomDbSet extends BaseDbSet {

    private Timestamp now;
    private String GET_STRING_BY_NAME;

    public ChatRoomDbSet() {
        super();
        CREATE_STRING = "CREATE TABLE IF NOT EXISTS ChatRooms(" +
                "Id INTEGER PRIMARY KEY," +
                "CreatedOn DATETIME NOT NULL," +
                "Name TEXT NOT NULL," +
                "Category TEXT NOT NULL," +
                "Rules TEXT NOT NULL);";
        DROP_STRING = "DROP TABLE ChatRooms;";
        LIST_STRING = "SELECT * FROM ChatRooms";
        GET_STRING = "SELECT * FROM ChatRooms WHERE Id = ?";
        GET_STRING_BY_NAME = "SELECT * FROM ChatRooms WHERE Name = ?";
        INSERT_OR_REPLACE_STRING = "REPLACE INTO ChatRooms(CreatedOn, Name, Category, Rules) VALUES(?,?,?,?)";
        DELETE_STRING = "DELETE FROM ChatRooms WHERE Id = ?";
        now = new Timestamp(System.currentTimeMillis());
    }

    public void Create() {
        ExecuteQuery(CREATE_STRING);
    }

    public void Drop() {
        ExecuteQuery(DROP_STRING);
    }

    public List<ChatRoomModel> List(){
        try {
            connection = DriverManager.getConnection(DB_STRING);
            Statement statement = connection.createStatement();
            statement.execute(LIST_STRING);

            ResultSet result = statement.getResultSet();

            List<ChatRoomModel> chatRooms = new ArrayList<ChatRoomModel>();

            while(result.next()){
                chatRooms.add(new ChatRoomModel(
                    result.getLong("Id"),
                    result.getTimestamp("CreatedOn"),
                    result.getString("Name"),
                    result.getString("Category"),
                    result.getString("Rules")
                ));
            }
            connection.close();
            return chatRooms;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ChatRoomModel GetOneById(long id) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING);
            statement.setLong(1, id);
            statement.execute();
            ResultSet result = statement.getResultSet();

            ChatRoomModel chatRoom = new ChatRoomModel(
                    result.getLong("Id"),
                    result.getTimestamp("CreatedOn"),
                    result.getString("Name"),
                    result.getString("Category"),
                    result.getString("Rules")
            );
            connection.close();
            return chatRoom;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ChatRoomModel GetOneByName(String name) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING_BY_NAME);
            statement.setString(1, name);
            statement.execute();
            ResultSet result = statement.getResultSet();

            ChatRoomModel chatRoom = new ChatRoomModel(
                    result.getLong("Id"),
                    result.getTimestamp("CreatedOn"),
                    result.getString("Name"),
                    result.getString("Category"),
                    result.getString("Rules")
            );
            connection.close();
            return chatRoom;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public List<ChatRoomModel> GetMultiple(long id){
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING);
            statement.setLong(1, id);
            statement.executeUpdate();

            ResultSet result = statement.getResultSet();
            List<ChatRoomModel> chatRooms = new ArrayList<>();

            while(result.next()){
                chatRooms.add(new ChatRoomModel(
                        result.getLong("Id"),
                        result.getTimestamp("CreatedOn"),
                        result.getString("Name"),
                        result.getString("Category"),
                        result.getString("Rules")
                ));
            }
            connection.close();
            return chatRooms;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void InsertOrReplace(ChatRoomModel chatRoom) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(INSERT_OR_REPLACE_STRING);
            statement.setTimestamp(1, now);
            statement.setString(2, chatRoom.getName());
            statement.setString(3, chatRoom.getCategory());
            statement.setString(4, chatRoom.getRules());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void Delete(ChatRoomDbSet model) {

    }
}
