package com.bdf.Spring.repository;

import com.bdf.Spring.entity.PowerDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepository extends JpaRepository<PowerDE,Long> {

}
