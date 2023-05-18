package com.bdf.Spring.repository;

import com.bdf.Spring.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Long> {

   public HeroEntity findByName(String name);
//
//   public List<HeroEntity> findByNameIs(String name);
//
//   public List<HeroEntity> findByNameIsNot(String name);
//
   public List<HeroEntity> findByUniverse(String universe);
//
//   public List<HeroEntity> findByUniverseIs(String universe);
//
//   public List<HeroEntity> findByUniverseIsNot(String universe);
//
//   public List<HeroEntity> findByHeroPower(String power);
//
//   public List<HeroEntity> findByHeroPowerIs(String power);
//
//   public List<HeroEntity> findByHeroPowerIsNot(String power);
}

