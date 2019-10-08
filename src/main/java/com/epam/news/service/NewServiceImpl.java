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
        return null;
    }

    @Override
    public New update(New entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public New get(int id) {
        return null;
    }

    @Override
    public List<New> getAll() {
        return null;
    }
}
