package com.epam.news.dao;

import com.epam.news.model.News;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaNewsDaoImpl implements NewsDao {
    private static final String DELETE_RECORD = "DELETE FROM News n WHERE n.id=:id";
    private static final String SELECT_ALL = "SELECT n FROM News n";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public News create(@Nonnull News news) {
        entityManager.persist(news);
        return news;
    }

    @Nullable
    @Override
    public News update(@Nonnull News news) {
        return entityManager.merge(news);
    }

    @Override
    public boolean delete(@Nonnull int id) {
        Query query = entityManager.createQuery(DELETE_RECORD);
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    @Nullable
    @Override
    public News get(@Nonnull int id) {
        return entityManager.find(News.class, id);
    }

    @Nonnull
    @Override
    public List<News> getAll() {
        List<News> list = entityManager.createQuery(SELECT_ALL).getResultList();
        return list;
//        return entityManager.createQuery(SELECT_ALL).getResultList();
    }
}
