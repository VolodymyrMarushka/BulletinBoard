package com.board.service.impl;

import com.board.entity.Category;
import com.board.repository.CRUDRepository;
import com.board.repository.impl.CategoryRepositoryImpl;
import com.board.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    private CRUDRepository<Category> repository = new CategoryRepositoryImpl();

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
