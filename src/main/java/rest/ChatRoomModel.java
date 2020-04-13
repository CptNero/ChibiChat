package rest;

import java.sql.Timestamp;

public class ChatRoomModel extends BaseModel {

    private String Name;

    public String Category;

    public String Rules;

    public ChatRoomModel(String name, String category, String rules) {
        Name = name;
        Category = category;
        Rules = rules;
    }

    public ChatRoomModel(long id, Timestamp createdOn, String name, String category, String rules) {
        super(id, createdOn);
        Name = name;
        Category = category;
        Rules = rules;
    }

    public String getName() { return Name; }

    public void setName(String name) { Name = name; }

    public String getCategory() { return Category; }

    public void setCategory(String category) { Category = category; }

    public String getRules() { return Rules; }

    public void setRules(String rules) { Rules = rules; }
}
