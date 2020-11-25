package com.board.repository;


public interface CRUDRepository<T> {

    void create(T entity);

    T findById(int id);

    void update(T entity);

    void deleteById(int id);
}
