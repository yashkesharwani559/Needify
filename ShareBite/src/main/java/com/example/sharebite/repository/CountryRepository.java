package com.example.sharebite.repository;

import com.example.sharebite.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findAll();

    Optional<Country> findByName(String name);
}
