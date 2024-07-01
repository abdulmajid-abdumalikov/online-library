package com.malikov.onlinelibrary.service;

import com.malikov.onlinelibrary.model.BaseModel;
import com.malikov.onlinelibrary.repository.BaseRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class BaseService<R extends BaseRepository<T>, T extends BaseModel> {
    R repository;
    public void save(T model) {
        repository.save(model);
    }
    public T get(Integer id) {
        return repository.get(id);
    }
    public void delete(Integer id) {
        repository.delete(id);
    }
    public List<T> getAll() {
        return repository.getAll();
    }
    public boolean update(String id, T model) {
        return repository.update(id, model);
    }

}
