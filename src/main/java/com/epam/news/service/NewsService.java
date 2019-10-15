package com.epam.news.service;

import com.epam.news.model.News;
import com.epam.news.util.exception.NotFoundAppException;

import java.util.List;

public interface NewsService {

    /**
     * Creates or updates record into table by specified data
     * @param entity the entity
     * @throws NotFoundAppException if record which should be updated is not found
     */
    void save(News entity) throws NotFoundAppException;

    /**
     * Deletes the entity from the table by specified key
     * @param id the key of entity
     * @throws NotFoundAppException if record is not found
     */
    void delete(int id) throws NotFoundAppException;

    /**
     * Gets the entity by specified key
     * @param id the key of entity
     * @return the entity
     * @throws NotFoundAppException if record is not found
     */
    News get(int id) throws NotFoundAppException;

    /**
     * Gets all entities
     * @return the list of entities
     *    if records are not found that returns empty list
     */
    String getAllInJSONFormat();
}
