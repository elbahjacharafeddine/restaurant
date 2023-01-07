package com.example.backendspring.DAO;

import com.example.backendspring.beans.Restaurant;
import com.example.backendspring.services.RestaurantInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RestaurantDAO implements RestaurantInterface {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> listar() {
        List<Map<String, Object>> list = template.queryForList("select * from restaurant");
        return list;
    }

    @Override
    public List<Map<String, Object>> listarId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Restaurant p) {
        String sql = "insert into restaurant(nom,adresse, latitude, longitude, rank, serie_id, zone_id)values(?,?,?,?,?,1,1)";
        return template.update(sql, p.getNom(), p.getAdresse(),p.getLatitude(),p.getLongitude(),p.getRank());
    }

    @Override
    public int edit(Restaurant p) {
        String sql="update restaurant set nom=?, adresse=?,latitude=?,longitude=?,rank=? where id=?";
        return template.update(sql,p.getNom(),p.getAdresse(),p.getLatitude(),p.getLongitude(),p.getRank(),p.getId());
    }

    @Override
    public int delete(int id) {
        String sql="delete from restaurant where id=?";
        return template.update(sql,id);
    }

}
