package com.board.service.impl;

import com.board.entity.Announcement;
import com.board.repository.CRUDRepository;
import com.board.repository.impl.AnnouncementRepositoryImpl;
import com.board.service.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService{

    private CRUDRepository<Announcement> repository = new AnnouncementRepositoryImpl();

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
