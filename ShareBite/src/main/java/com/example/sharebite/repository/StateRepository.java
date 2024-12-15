package com.example.sharebite.repository;

import com.example.sharebite.entity.Country;
import com.example.sharebite.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findAll();

    Optional<State> findByCountryAndName(Country country, String name);

   Optional<State> findByName(String name);

}
