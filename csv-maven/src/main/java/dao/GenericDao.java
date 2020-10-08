package dao;

import java.util.List;

public interface GenericDao<T> {
    T create(T entity);

}
