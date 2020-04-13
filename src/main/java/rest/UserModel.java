package rest;

import java.sql.Timestamp;

public class UserModel extends BaseModel {

    private String Nickname;

    private int Age;

    private boolean Sex;

    private String Interests;

    public UserModel(String nickname, int age, boolean sex, String interests) {
        Nickname = nickname;
        Age = age;
        Sex = sex;
        Interests = interests;
    }

    public UserModel(long id, Timestamp createdOn, String nickname, int age, boolean sex, String interests) {
        super(id, createdOn);
        Nickname = nickname;
        Age = age;
        Sex = sex;
        Interests = interests;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) { Nickname = nickname; }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

    public String getInterests() {
        return Interests;
    }

    public void setInterests(String interests) {
        Interests = interests;
    }
}
