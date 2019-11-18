package com.epam.news.dao;

import com.epam.news.model.News;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface NewsDao {

    /**
     * Creates record into table for the specified entity
     * @param news the entity
     * @return the entity with initialized key
     */
    News create(@Nonnull News news);

    /**
     * Updates record into table for the specified entity
     * @param news the entity
     * @return the entity
     *   if record for specified entity are not found that returns null
     */
    @Nullable
    News update(@Nonnull News news);

    /**
     * Deletes the entity from the table by specified key
     * @param id the key of entity
     * @return {@code true} if the entity was deleted from the table, else
     *         {@code false}
     */
    boolean delete(@Nonnull int id);

    /**
     * Gets the entity by specified key
     * @param id the key of entity
     * @return the entity
     *   if record for specified key are not found that returns null
     */
    @Nullable
    News get(@Nonnull int id);

    /**
     * Gets all entities
     * @return the list of entities
     *    if records are not found that returns empty list
     */
    @Nonnull
    List<News> getAll();

}
