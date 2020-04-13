package dao;

import org.sqlite.SQLiteConfig;

import java.sql.*;

public class BaseDbSet {

    protected String CREATE_STRING;

    protected String DROP_STRING;

    protected String LIST_STRING;

    protected String GET_STRING;

    protected String INSERT_OR_REPLACE_STRING;

    protected String DELETE_STRING;

    public final String DB_STRING = "jdbc:sqlite:chibichat";

    protected Connection connection;

    public SQLiteConfig config;

    public BaseDbSet() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        SQLiteConfig config = new SQLiteConfig();
        config.setEncoding(SQLiteConfig.Encoding.UTF8);
    }

    public void ExecuteQuery(String STATEMENT) {
        try {
            connection = DriverManager.getConnection(DB_STRING);
            Statement statement = connection.createStatement();
            statement.executeUpdate(STATEMENT);
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
