package com.board.service.impl;

import com.board.entity.User;
import com.board.repository.CRUDRepository;
import com.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userRepositoryImpl")
    private CRUDRepository<User> repository;

    @Override
    public void save(User user) {
        repository.create(user);
    }

    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(User user) {
        repository.update(user);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
