package com.example.sharebite.repository;

import com.example.sharebite.entity.City;
import com.example.sharebite.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAll();

    Optional<City> findByStateAndName(State state, String name);
}
