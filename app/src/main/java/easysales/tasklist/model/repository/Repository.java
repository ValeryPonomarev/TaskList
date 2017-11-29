package easysales.tasklist.model.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.List;

import easysales.tasklist.model.BaseModel;

/**
 * Created by lordp on 03.11.2017.
 */

public interface Repository<I extends BaseModel> {
    @Nullable I get(int id);
    @NonNull List<I> getAll();
    void delete(@NonNull I item) throws SQLException;
    void create(@NonNull I item) throws SQLException;
    void update(@NonNull I item) throws SQLException;
    void save(@NonNull I item) throws SQLException ;
}
