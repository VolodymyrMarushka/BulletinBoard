package com.board.repository.impl;

import com.board.entity.User;
import com.board.repository.CRUDRepository;
import com.board.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserRepositoryImpl implements CRUDRepository<User> {

    @Override
    public void create(User user) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public User findById(int id) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, id);

        return user;
    }

    @Override
    public void update(User user) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        User user1 = entityManager.merge(user);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(int id) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.getReference(User.class, id);
        entityManager.remove(user);
        transaction.commit();

        /* Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :uId");
        query.setParameter("uId", id);
        System.out.println("Deleted rows = " + query.executeUpdate());*/
    }
}
