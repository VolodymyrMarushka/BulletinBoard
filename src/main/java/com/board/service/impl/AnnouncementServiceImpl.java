package com.board.service.impl;

import com.board.entity.Announcement;
import com.board.repository.CRUDRepository;
import com.board.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{

    @Autowired
    @Qualifier(value = "announcementRepositoryImpl")
    private CRUDRepository<Announcement> repository;

    @Override
    public void save(Announcement announcement) {
        repository.create(announcement);
    }

    @Override
    public Announcement findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(Announcement a) {
        repository.update(a);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
