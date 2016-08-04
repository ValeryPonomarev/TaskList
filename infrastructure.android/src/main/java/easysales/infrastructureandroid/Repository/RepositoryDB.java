package easysales.infrastructureandroid.Repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.easysales.Domain.EntityBase;
import com.easysales.Domain.IEntity;
import com.easysales.Domain.IEntityFactory;
import com.easysales.Repository.RepositoryBase;
import com.easysales.UnitOfWork.IUnitOfWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drmiller on 04.08.2016.
 */
public abstract class RepositoryDB<T extends EntityBase> extends RepositoryBase {

    private Context context;
    private SQLiteOpenHelper dbHelper;
    private static final String LOG_TAG = "RepositoryDB";
    private SQLiteDatabase database = null;
    private IEntityFactory<T> entityFactory;

    public RepositoryDB(Context context, IUnitOfWork unitOfWork)
    {
        super(unitOfWork);
        this.context = context;
        dbHelper = DBHelper.getInstance(this.context, getTableName(), null, getTableVersion(), getTableCreateQuery(), getTableUpdateQuery());
    }

    protected abstract String getBaseQuery();
    protected abstract String getBaseWhereClause(Object key);
    protected abstract String getTableName();
    protected abstract int getTableVersion();
    protected abstract String getTableCreateQuery();
    protected abstract String getTableUpdateQuery();

    protected List<T> buildEntitiesFromSql(String sql)
    {
        ArrayList<T> entities = new ArrayList<>();
        Cursor cursor = null;
        try {
            Log.d(LOG_TAG, sql);
            cursor = getDatabase().rawQuery(sql, null);

            while (cursor.moveToNext())
            {
                entities.add(buildEntityFromCursor(cursor));
            }
        } finally {
            if(cursor != null) cursor.close();
        }
        return entities;
    }

    protected SQLiteDatabase getDatabase()
    {
        if(database == null) {
            try {
                database = dbHelper.getWritableDatabase();
            } catch (SQLiteException exc) {
                database = dbHelper.getReadableDatabase();
            }
        }
        return database;
    }

    protected T buildEntitiyFromSql(String sql)
    {
        T entity = null;
        Cursor cursor = null;
        try {
            Log.d(LOG_TAG, sql);
            cursor = getDatabase().rawQuery(sql, null);
            while (cursor.moveToNext())
            {
                entity = buildEntityFromCursor(cursor);
            }
        } finally {
            if(cursor != null) cursor.close();
        }
        return entity;
    }

    protected T buildEntityFromCursor(Cursor cursor)
    {
        T entity = this.entityFactory.buildEntity(cursor);
        return entity;
    }

    @Override
    public IEntity findBy(Object key) {
        String query = getBaseQuery() + getBaseWhereClause(key);
        return buildEntitiyFromSql(query);
    }

    @Override
    public List findAll() {
        return buildEntitiesFromSql(getBaseQuery());
    }

    @Override
    public void persistDeletedItem(IEntity item) {
        String query = String.format("DELETE FROM %1$s %2$s", getTableName(), getBaseWhereClause(item.getKey()));
        Log.d(LOG_TAG, query);
        getDatabase().execSQL(query);

    }
}

