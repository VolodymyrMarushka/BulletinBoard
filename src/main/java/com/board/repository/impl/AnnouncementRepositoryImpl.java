package com.board.repository.impl;

import com.board.entity.Announcement;
import com.board.repository.CRUDRepository;
import com.board.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AnnouncementRepositoryImpl implements CRUDRepository<Announcement> {

    @Override
    public void create(Announcement announcement) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(announcement);
        entityManager.getTransaction().commit();
    }

    @Override
    public Announcement findById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        return entityManager.find(Announcement.class,id);
    }

    @Override
    public void update(Announcement announcement) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Announcement newAnnouncement = entityManager.merge(announcement);
        entityManager.persist(newAnnouncement);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteById(int id) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Announcement a WHERE a.id = :aId");
        query.setParameter("aId", id);
        System.out.println("Deleted rows = " + query.executeUpdate());
        entityManager.getTransaction().commit();
    }
}
