package easysales.tasklist.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by lordp on 16.07.2017.
 */

public class BaseModel {
    @DatabaseField
    private Date dateCreate;

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
