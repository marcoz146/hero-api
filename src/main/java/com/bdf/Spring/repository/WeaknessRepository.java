package com.bdf.Spring.repository;

import com.bdf.Spring.entity.WeaknessDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaknessRepository extends JpaRepository<WeaknessDE,Long> {
}
