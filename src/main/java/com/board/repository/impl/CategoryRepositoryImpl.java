package com.board.repository.impl;

import com.board.entity.Category;
import com.board.repository.CRUDRepository;
import com.board.util.EntityManagerUtil;
import lombok.Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Data
public class CategoryRepositoryImpl implements CRUDRepository<Category> {

    @Override
    public void create(Category category) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(category);
        transaction.commit();

    }

    @Override
    public Category findById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, id);
        return category;
    }

    @Override
    public void update(Category category) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Category updatedCategory = entityManager.merge(category);
        entityManager.persist(category);
        entityManager.getTransaction().commit();
    }


    @Override
    public void deleteById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Category c WHERE c.id = :cId");
        query.setParameter("cId", id);
        System.out.println("Deleted rows = " + query.executeUpdate());
        transaction.commit();
    }
}
