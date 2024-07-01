package com.malikov.onlinelibrary.repository;

import com.malikov.onlinelibrary.model.BaseModel;
import com.malikov.onlinelibrary.utils.Beans;

import java.sql.Connection;
import java.util.List;

public interface BaseRepository<T extends BaseModel> {

    Connection connection = Beans.getConnection();

    void save(T model);
    T get(Integer id);
    void delete(Integer id);
    List<T> getAll();
    boolean update(String id, T model);

}
