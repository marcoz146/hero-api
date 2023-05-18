package com.bdf.Spring.controller;

import com.bdf.Spring.controller.dto.UniverseDTO;
import com.bdf.Spring.service.UniverseService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/universes")
public class UniverseController {

    private final UniverseService universeService;

    @Autowired
    public UniverseController(UniverseService universeService) {
        this.universeService = universeService;
    }

    @PostMapping()
    @SneakyThrows
    public ResponseEntity createUniverse(@RequestBody @Valid UniverseDTO newUniverse) {
        return new ResponseEntity<>(universeService.createUniverse(newUniverse), HttpStatus.CREATED);
    }

    @GetMapping()
    @SneakyThrows
    public List<UniverseDTO> findAllUniverses() {
        return universeService.allUniverses();
    }
}
