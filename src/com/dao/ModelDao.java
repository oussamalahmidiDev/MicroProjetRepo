package com.dao;

import com.models.Model;

import java.util.List;

public interface ModelDao {
    boolean create(Model m) throws Exception ;
    Model find(int id) throws Exception ;
    int delete (int id) throws Exception;

    List<Model> getAll() throws Exception;

}
