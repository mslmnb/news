package com.epam.news.dao;

import com.epam.news.model.News;

import java.util.List;

public interface NewsDAO {

    /**
     * Creates record into table for the specified entity
     * @param nevv the entity
     * @return the entity with initialized key
     */
    News create(News nevv);

    /**
     * Updates record into table for the specified entity
     * @param nevv the entity
     * @return the entity
     *   if record for specified entity are not found that returns null
     */
    News update(News nevv);

    /**
     * Deletes the entity from the table by specified key
     * @param id the key of entity
     * @return {@code true} if the entity was deleted from the table, else
     *         {@code false}
     */
    boolean delete(int id);

    /**
     * Gets the entity by specified key
     * @param id the key of entity
     * @return the entity
     *   if record for specified key are not found that returns null
     */
    News get(int id);

    /**
     * Gets all entities
     * @return the list of entities
     *    if records are not found that returns empty list
     */
    List<News> getAll();

}
