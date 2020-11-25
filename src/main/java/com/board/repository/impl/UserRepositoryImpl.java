package com.board.repository.impl;

import com.board.entity.User;
import com.board.repository.CRUDRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Repository
@Transactional
public class UserRepositoryImpl implements CRUDRepository<User> {

    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public User findById(int id) {
       /* User user = em.find(User.class, id);

        user.getPhones().get(0);
        user.getRoles().forEach(System.out::println);*/

        /*TypedQuery<User> query =
                em.createQuery("FROM User u JOIN FETCH u.phones " +
                                "JOIN FETCH u.roles WHERE u.id = : uId",
                        User.class);*/

        TypedQuery<User> query =
                em.createQuery("FROM User u " +
                                "JOIN FETCH u.phones " +
                                "JOIN FETCH u.email " +
                                "JOIN FETCH u.address " +
                                "JOIN FETCH u.roles " +
                                "WHERE u.id = : uId",
                        User.class);
        query.setParameter("uId", id);

        return query.getSingleResult();
    }

    @Override
    public void update(User user) {

        User updatedUser = em.merge(user);
        em.persist(updatedUser);
    }

    @Override
    public void deleteById(int id) {

       /* Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :uId");
        query.setParameter("uId", id);
        System.out.println("Deleted rows = " + query.executeUpdate());*/

        User user = em.getReference(User.class, id);
        em.remove(user);

    }
}
