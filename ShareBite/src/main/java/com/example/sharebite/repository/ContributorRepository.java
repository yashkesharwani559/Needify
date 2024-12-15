package com.example.sharebite.repository;

import com.example.sharebite.entity.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor, Long> {

    List<Contributor> findAll();
}
