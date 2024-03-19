package org.example;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T>{
    void addObj(T object) throws SQLException;
    void delete(T object) throws SQLException;
    void update(T object) throws SQLException;
    List<T> getAll() throws SQLException;
}
