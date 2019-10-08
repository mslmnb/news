package com.epam.news.service;

import com.epam.news.dao.NewDAO;
import com.epam.news.model.New;

import java.util.List;

public class NewServiceImpl implements NewService {
    private final NewDAO dao;

    public NewServiceImpl(NewDAO dao) {
        this.dao = dao;
    }

    @Override
    public New create(New entity) {
        if (!entity.isNew()) {
            entity.setId(null);  /// подумать
        }
        return dao.save(entity);
    }

    @Override
    public New update(New entity) {
        return dao.save(entity); // if record for specified entity are not found that returns null
    }

    //         * @return {@code true} if the entity was deleted from the table, else
//            *         {@code false}
    @Override
    public boolean delete(int id) {
        dao.delete(id);
        return false;
    }

    @Override
    public New get(int id) {
        return dao.get(id); // if record for specified key are not found that returns null
    }

    @Override
    public List<New> getAll() {
        return dao.getAll();
    }
}
