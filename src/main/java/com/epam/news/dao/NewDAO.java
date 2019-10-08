package com.epam.news.dao;

import com.epam.news.model.New;

import java.util.List;

public interface NewDAO {

    New save(New new_);

    void delete(int id);

    New get(int id);

    List<New> getAll();

}
