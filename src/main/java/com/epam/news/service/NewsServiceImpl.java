package com.epam.news.service;

import com.epam.news.dao.NewsDAO;
import com.epam.news.model.News;

import java.util.List;

import static com.epam.news.util.ValidationUtil.checkNotFound;

public class NewsServiceImpl implements NewsService {
    private final NewsDAO dao;

    public NewsServiceImpl(NewsDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(News entity) {
        if (entity.isNew()) {
            dao.create(entity);
        } else {
            checkNotFound(dao.update(entity));
        }
    }

    @Override
    public void delete(int id) {
        checkNotFound(dao.delete(id));
    }

    @Override
    public News get(int id) {
        return checkNotFound(dao.get(id));
    }

    @Override
    public List<News> getAll() {
        return dao.getAll();
    }
}
