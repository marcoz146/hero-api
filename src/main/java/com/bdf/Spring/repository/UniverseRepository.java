package com.bdf.Spring.repository;

import com.bdf.Spring.entity.UniverseDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverseRepository extends JpaRepository<UniverseDE,Long> {
}
