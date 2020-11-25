package com.board.service;


public interface CRUDService<T> {

    void save(T entity);

    T findById(int id);

    void update(T entity);

    void deleteById(int id);

}
