package dao;

import rest.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDbSet extends BaseDbSet {

    private Timestamp now;
    private String GET_STRING_BY_NAME;
    private String GET_STRING_FILTERED_BY_NAME;
    private String GET_STRING_FILTERED_BY_INTEREST;
    private String GET_STRING_FILTERED_BY_NAME_AND_INTEREST;

    public UserDbSet() {
        super();
        CREATE_STRING = "CREATE TABLE IF NOT EXISTS Users(" +
                "Id INTEGER PRIMARY KEY," +
                "CreatedOn DATETIME NOT NULL," +
                "Nickname TEXT NOT NULL," +
                "Age INTEGER NOT NULL," +
                "Sex INTEGER NOT NULL," +
                "Interests TEXT NOT NULL);";
        DROP_STRING = "DROP TABLE Users;";
        LIST_STRING = "SELECT * FROM Users;";
        GET_STRING = "SELECT * FROM Users WHERE Id = ?;";
        GET_STRING_BY_NAME = "SELECT * FROM Users WHERE Nickname = ?;";
        GET_STRING_FILTERED_BY_NAME = "SELECT * FROM Users WHERE Nickname LIKE ?;";
        GET_STRING_FILTERED_BY_INTEREST = "SELECT * FROM Users WHERE Interests LIKE ?;";
        GET_STRING_FILTERED_BY_NAME_AND_INTEREST = "SELECT * FROM Users WHERE Nickname LIKE ? AND Interests LIKE ?;";
        INSERT_OR_REPLACE_STRING = "REPLACE INTO Users(CreatedOn, Nickname, Age, Sex, Interests) VALUES(?,?,?,?,?);";
        DELETE_STRING = "DELETE FROM Users WHERE Id = ?;";
        now = new Timestamp(System.currentTimeMillis());
    }

    public void Create() {
        ExecuteQuery(CREATE_STRING);
    }

    public void Drop() {
        ExecuteQuery(DROP_STRING);
    }

    public List<UserModel> List() {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            Statement statement = connection.createStatement();
            statement.execute(LIST_STRING);

            ResultSet result = statement.getResultSet();

            List<UserModel> users = new ArrayList<UserModel>();

            while(result.next()){
                users.add(new UserModel(
                        result.getLong("Id"),
                        result.getTimestamp("CreatedOn"),
                        result.getString("NickName"),
                        result.getInt("Age"),
                        result.getBoolean("Sex"),
                        result.getString("Interests")
                ));
            }
            connection.close();
            return users;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public UserModel GetById(long id) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING);
            statement.setLong(1, id);
            statement.execute();
            ResultSet result = statement.getResultSet();

            UserModel user = new UserModel(
                    result.getLong("Id"),
                    result.getTimestamp("CreatedOn"),
                    result.getString("NickName"),
                    result.getInt("Age"),
                    result.getBoolean("Sex"),
                    result.getString("Interests")
            );
            connection.close();
            return user;
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return  null;
    }

    public UserModel GetByName(String nickname) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING_BY_NAME);
            statement.setString(1, nickname);
            statement.execute();
            ResultSet result = statement.getResultSet();

            UserModel user = new UserModel(
                    result.getLong("Id"),
                    result.getTimestamp("CreatedOn"),
                    result.getString("NickName"),
                    result.getInt("Age"),
                    result.getBoolean("Sex"),
                    result.getString("Interests")
            );
            connection.close();
            return user;
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return  null;
    }

    public List<UserModel> GetFilteredByName(String nickname) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING_FILTERED_BY_NAME);
            statement.setString(1, nickname + "%");
            statement.execute();
            ResultSet result = statement.getResultSet();

            List<UserModel> users = new LinkedList<UserModel>();

            while (result.next()){
                users.add(new UserModel(
                        result.getLong("Id"),
                        result.getTimestamp("CreatedOn"),
                        result.getString("NickName"),
                        result.getInt("Age"),
                        result.getBoolean("Sex"),
                        result.getString("Interests")
                ));
            }

            connection.close();
            return users;
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return  null;
    }

    public List<UserModel> GetFilteredByInterest(String interest) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING_FILTERED_BY_INTEREST);
            statement.setString(1, interest + "%");
            statement.execute();
            ResultSet result = statement.getResultSet();

            List<UserModel> users = new LinkedList<UserModel>();

            while (result.next()){
                users.add(new UserModel(
                        result.getLong("Id"),
                        result.getTimestamp("CreatedOn"),
                        result.getString("NickName"),
                        result.getInt("Age"),
                        result.getBoolean("Sex"),
                        result.getString("Interests")
                ));
            }
            connection.close();
            return users;
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return  null;
    }

    public List<UserModel> GetFilteredByNameAndInterest(String name, String interest) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(GET_STRING_FILTERED_BY_NAME_AND_INTEREST);
            statement.setString(1, name + "%");
            statement.setString(2, interest + "%");
            statement.execute();
            ResultSet result = statement.getResultSet();

            List<UserModel> users = new LinkedList<UserModel>();

            while (result.next()){
                users.add(new UserModel(
                        result.getLong("Id"),
                        result.getTimestamp("CreatedOn"),
                        result.getString("NickName"),
                        result.getInt("Age"),
                        result.getBoolean("Sex"),
                        result.getString("Interests")
                ));
            }
            connection.close();
            return users;
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return  null;
    }

    public void InsertOrReplace(UserModel user) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            PreparedStatement statement = connection.prepareStatement(INSERT_OR_REPLACE_STRING);
            statement.setTimestamp(1, now);
            statement.setString(2, user.getNickname());
            statement.setInt(3, user.getAge());
            statement.setBoolean(4, user.isSex());
            statement.setString(5, user.getInterests());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void Delete(UserDbSet userModel) {

    }
}
