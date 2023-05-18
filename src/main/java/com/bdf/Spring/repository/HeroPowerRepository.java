package com.bdf.Spring.repository;

import com.bdf.Spring.entity.HeroPowerDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroPowerRepository extends JpaRepository<HeroPowerDE,Long> {
}
