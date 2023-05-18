package com.bdf.Spring.controller;

import com.bdf.Spring.controller.dto.HeroDTO;
import com.bdf.Spring.service.HeroService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {


    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }


    @GetMapping()
    public List<HeroDTO> findAll() {
        return heroService.allHeroes();
    }

    @PostMapping()
    @SneakyThrows
    public ResponseEntity newHero(@RequestBody @Valid HeroDTO newHero) {
        return new ResponseEntity<>(heroService.create(newHero), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @SneakyThrows
    public ResponseEntity<HeroDTO> one(@PathVariable @Valid Long id) {
        return new ResponseEntity<>(heroService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    @SneakyThrows
    public ResponseEntity deleteHero(@PathVariable @Valid Long id) {
        heroService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name")
    public ResponseEntity<HeroDTO> heroByName (@RequestParam String name){
        return ResponseEntity.ok(heroService.getByName(name));
    }


//    @GetMapping("/name")
//    public ResponseEntity<List<HeroDTO>> heroByUniverse (@RequestParam String name){
//        return ResponseEntity.ok(heroService.getHeroesByUniverse(name));
//    }
}
