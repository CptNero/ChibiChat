package rest;

import java.sql.Timestamp;

public class BaseModel {

    private long Id;

    private Timestamp CreatedOn;

    public BaseModel(){}

    public BaseModel(long id, Timestamp createdOn) {
        Id = id;
        CreatedOn = createdOn;
    }

    public long getId() { return Id; }

    public void setId(long id) { Id = id; }

    public Timestamp getCreatedOn() { return CreatedOn; }

    public void setCreatedOn(Timestamp createdOn) { CreatedOn = createdOn; }
}
