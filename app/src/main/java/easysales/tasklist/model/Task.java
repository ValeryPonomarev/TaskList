package easysales.tasklist.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.sql.SQLException;
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
    public Integer id;

    @DatabaseField
    public String number;

    @DatabaseField
    public String description;

    @DatabaseField
    public Date dateCreate;

    @DatabaseField
    public int spandMinuts;

    public static SimpleDao<Task> getDao() throws SQLException {
        if(dao == null) {
            dao = new SimpleDao<>(ApplicationWrapper.getInstance().getDatabaseHelper().getConnectionSource(), Task.class);
        }

        return dao;
    }
}
