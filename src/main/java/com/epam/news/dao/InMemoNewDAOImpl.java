package com.epam.news.dao;

import com.epam.news.model.New;
import com.epam.news.util.NewsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoNewDAOImpl implements NewDAO {
    private AtomicInteger idCounter = new AtomicInteger(100000);
    private Map<Integer, New> repository = new ConcurrentHashMap<>();

    {
        NewsUtil.NEWS.forEach(this::save);
    }

    @Override
    public New save(New nevv) {
        if (nevv.isNew()) {
            nevv.setId(idCounter.getAndIncrement());
        }
        repository.put(nevv.getId(), nevv);
        return nevv;
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

     /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this repository contains no mapping for the key.
     * @param id  the specified key
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this repository contains no mapping for the key
     */
    @Override
    public New get(int id) {
        return repository.get(id);
    }

    @Override
    public List<New> getAll() {
        return new ArrayList<>(repository.values());
    }
}
