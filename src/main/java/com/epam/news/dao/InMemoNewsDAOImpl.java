package com.epam.news.dao;

import com.epam.news.model.News;
import com.epam.news.util.NewsUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoNewsDAOImpl implements NewsDAO {
    private AtomicInteger idCounter = new AtomicInteger(100000);
    private Map<Integer, News> repository = new ConcurrentHashMap<>();

    {
        NewsUtil.NEWS.forEach(this::create);
    }

    @Override
    public News create(News news) {
        news.setId(idCounter.getAndIncrement());
        repository.put(news.getId(), news);
        return news;
    }

    @Override
    public News update(News news) {
        int id = news.getId();
        News result = news;
        if (repository.containsKey(id)) {
            repository.put(id, news);
        } else {
            result = null;
        }
        return result;
    }

     /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this repository contains no mapping for the key.
     * @param id  the specified key
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this repository contains no mapping for the key
     */
    @Override
    public News get(int id) {
        return repository.get(id);
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        if (repository.containsKey(id)) {
            repository.remove(id);
            result = true;
        }
        return result;
    }

    @Override
    public List<News> getAll() {
        return new ArrayList<>(repository.values());
    }
}
