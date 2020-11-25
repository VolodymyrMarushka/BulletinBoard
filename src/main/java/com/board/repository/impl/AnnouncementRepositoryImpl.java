package com.board.repository.impl;

import com.board.entity.Announcement;
import com.board.repository.CRUDRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Repository
@Transactional
public class AnnouncementRepositoryImpl implements CRUDRepository<Announcement> {

    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Override
    public void create(Announcement announcement) {
        em.persist(announcement);
    }

    @Override
    public Announcement findById(int id) {

        TypedQuery<Announcement> query = em.createQuery("FROM Announcement a WHERE a.id = :aId",
                                                        Announcement.class);
        query.setParameter("aId", id);

        return query.getSingleResult();
    }

    @Override
    public void update(Announcement announcement) {

        Announcement mergeAnnouncement = em.merge(announcement);
        em.persist(mergeAnnouncement);
    }

    @Override
    public void deleteById(int id) {

        Query query = em.createQuery("DELETE FROM Announcement a WHERE a.id = :aId");
        query.setParameter("aId", id);
        System.out.println("Deleted rows = " + query.executeUpdate());
    }
}
