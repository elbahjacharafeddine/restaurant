package com.example.backendspring.services;

import com.example.backendspring.beans.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantInterface {
    public List<Map<String, Object>>listar();
    public List<Map<String, Object>>listarId(int id);
    public int add(Restaurant p);
    public int edit(Restaurant p);
    public int delete(int id);

}
