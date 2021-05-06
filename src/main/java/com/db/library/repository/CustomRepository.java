package com.db.library.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable>
extends CrudRepository<T, ID> {
    void refresh(T t);
    void flush();
}