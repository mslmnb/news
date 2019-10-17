package com.epam.news.service;

import com.epam.news.dao.NewsDAO;
import com.epam.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.news.util.ValidationUtil.checkNotFound;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsDAO dao;

    @Autowired
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
    public String getAllInJSONFormat() {
        return getJsonString(dao.getAll());
    }


    private static String getJsonString(List<News> news) {
        return "[ "
                + news.stream().map(n -> n.getJsonString()).collect(Collectors.joining(", "))
                + "]";
    }

}
