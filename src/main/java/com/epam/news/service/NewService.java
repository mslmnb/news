package com.epam.news.service;

import com.epam.news.model.New;

import java.util.List;

public interface NewService {

    /**
     * Creates record into table for the specified entity
     * @param entity the entity
     * @return the entity with initialized key
     */
    New create(New entity);

    /**
     * Updates record into table for the specified entity
     * @param entity the entity
     * @return the entity
     *   if record for specified entity are not found that returns null
     */
    New update(New entity);

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
    New get(int id);

    /**
     * Gets all entities
     * @return the list of entities
     *    if records are not found that returns empty list
     */
    List<New> getAll();
}
