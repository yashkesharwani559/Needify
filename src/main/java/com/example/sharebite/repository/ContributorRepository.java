package com.example.sharebite.repository;

import com.example.sharebite.entity.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor, Long> {

    List<Contributor> findAll();

    Contributor save(Contributor contributor);

    Optional<Contributor> findByPhoneNo(String phoneNo);

    Optional<Contributor> findByEmail(String email);

    Optional<Contributor> findByUsername(String username);

    @Override
    void delete(Contributor contributor);

}
