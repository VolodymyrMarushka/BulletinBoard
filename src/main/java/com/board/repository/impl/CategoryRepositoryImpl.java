package com.board.repository.impl;

import com.board.entity.Category;
import com.board.repository.CRUDRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CRUDRepository<Category> {

    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Override
    public void create(Category category) {
        em.persist(category);
    }

    @Override
    public Category findById(int id) {
        TypedQuery<Category> query = em.createQuery("FROM Category c WHERE c.id = :cId", Category.class);
        query.setParameter("cId", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Category category) {

        Category mergeCategory = em.merge(category);
        em.persist(mergeCategory);
    }


    @Override
    public void deleteById(int id) {
        Category category = em.getReference(Category.class, id);
        em.remove(category);
    }
}
