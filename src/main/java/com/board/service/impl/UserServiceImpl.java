package com.board.service.impl;

import com.board.entity.User;
import com.board.repository.CRUDRepository;
import com.board.repository.impl.UserRepositoryImpl;
import com.board.service.UserService;

public class UserServiceImpl implements UserService {


    private CRUDRepository<User> repository = new UserRepositoryImpl();

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
