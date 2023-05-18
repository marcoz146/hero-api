package com.bdf.Spring.repository;

import com.bdf.Spring.entity.GenderDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderDE, Long> {
}
