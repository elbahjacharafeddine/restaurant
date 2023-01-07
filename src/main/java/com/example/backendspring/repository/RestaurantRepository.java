package com.example.backendspring.repository;

import com.example.backendspring.beans.Restaurant;
import com.example.backendspring.beans.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    @Query(value = "select * from restaurant where id =:id",nativeQuery = true)
    Restaurant getRestaurantById(Long id);

    @Query(value = "select * from restaurant",nativeQuery = true)
    List<Restaurant> getAllRestaurant();
    Restaurant findById(int id);
    @Query(value = "select * from restaurant where etat=0",nativeQuery = true)
    List<Restaurant> findAllBy();
    @Query(value = "select * from restaurant where etat=1",nativeQuery = true)
    List<Restaurant> findAllByV();
    @Query(value="select count(r.id),z.nom from restaurant r,zone z where r.zone_id=z.id GROUP BY (r.zone_id)",nativeQuery = true)
    List<Object[]> listeRestaurant();
    @Query(value="select count(r.id),v.nom from restaurant r,zone z,ville v where r.zone_id=z.id and z.ville_id=v.id  GROUP BY (z.ville_id)",nativeQuery = true)
    List<Object[]> listeRestaurantville();

}
