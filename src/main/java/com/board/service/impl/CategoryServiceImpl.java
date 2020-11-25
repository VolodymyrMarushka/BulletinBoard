package com.board.service.impl;

import com.board.entity.Category;
import com.board.repository.CRUDRepository;
import com.board.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    @Qualifier(value = "categoryRepositoryImpl")
    private CRUDRepository<Category> repository;

    @Override
    public void save(Category category) {
        repository.create(category);
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(Category category) {
        repository.update(category);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
