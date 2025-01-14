package com.example.sharebite.repository;

import com.example.sharebite.entity.ContributorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContributorTypeRepository extends JpaRepository<ContributorType, Integer> {
    public ContributorType findByName(String name);

    public List<ContributorType> findAll();
}
