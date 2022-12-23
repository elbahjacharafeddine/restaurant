package com.example.backendspring.repository;

import com.example.backendspring.beans.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    @Query(value= "select *  from Zone ",nativeQuery = true)
    Collection<?> findAllZones();
}
