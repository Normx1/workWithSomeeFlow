package com.example.Dao;

import com.example.User.User;

import java.util.List;

public interface BasicDao<T> {
    List<T> getAll();

    T getById(int id);

    T deleteById(int id);

    T updateById(T model);

    T create(T model);


}
