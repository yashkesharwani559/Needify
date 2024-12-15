package com.example.sharebite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sharebite.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    UserType getUserTypeByName(String name);
}
