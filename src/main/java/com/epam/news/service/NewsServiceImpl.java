package com.epam.news.service;

import com.epam.news.dao.NewsDao;
import com.epam.news.model.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Nonnull;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.news.util.ValidationUtil.checkNotFound;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsDao dao;

    @Autowired
    public NewsServiceImpl(NewsDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(@Nonnull News entity) {
        if (entity.isNew()) {
            dao.create(entity);
        } else {
            checkNotFound(dao.update(entity));
        }
    }

    @Override
    public void remove(@Nonnull int id) {
        checkNotFound(dao.delete(id));
    }

    @Override
    public String getById(@Nonnull int id) {
        return checkNotFound(dao.get(id).getJsonString());
    }

    @Nonnull
    @Override
    public String getAll() {
        return getJsonString(dao.getAll());
    }

    @Nonnull
    private static String getJsonString(List<News> news) {
        return "[ "
                + news.stream().map(n -> n.getJsonString()).collect(Collectors.joining(", "))
                + "]";
    }

}
