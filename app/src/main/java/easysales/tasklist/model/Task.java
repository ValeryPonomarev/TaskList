package easysales.tasklist.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import easysales.tasklist.ApplicationWrapper;
import easysales.tasklist.database.SimpleDao;

/**
 * Created by lordp on 16.07.2017.
 */

@DatabaseTable(tableName = "Task")
public class Task extends BaseModel implements Serializable {
    private static SimpleDao<Task> dao;

    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField
    private String number;

    @DatabaseField
    private Date date;

    @DatabaseField
    private String description;

    @DatabaseField
    private int spandMinuts;

    public static SimpleDao<Task> getDao() throws SQLException {
        if(dao == null) {
            dao = new SimpleDao<>(ApplicationWrapper.getDatabaseHelper().getConnectionSource(), Task.class);
        }

        return dao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSpandMinuts() {
        return spandMinuts;
    }

    public void setSpandMinuts(int spandMinuts) {
        this.spandMinuts = spandMinuts;
    }

    public static class List extends ArrayList<Task> {}
}
