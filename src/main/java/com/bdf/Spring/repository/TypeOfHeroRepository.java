package com.bdf.Spring.repository;

import com.bdf.Spring.entity.TypeOfHeroDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfHeroRepository extends JpaRepository<TypeOfHeroDE, Long> {
}
