package easysales.tasklist.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by lordp on 16.07.2017.
 */

public class SimpleDao<T> extends BaseDaoImpl<T, Integer> {
    public SimpleDao(ConnectionSource connectionSource, Class<T> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
