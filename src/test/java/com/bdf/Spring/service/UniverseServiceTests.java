package com.bdf.Spring.service;

import com.bdf.Spring.controller.dto.UniverseDTO;
import com.bdf.Spring.entity.UniverseDE;
import com.bdf.Spring.mapper.UniverseBOMapper;
import com.bdf.Spring.mapper.UniverseMapper;
import com.bdf.Spring.repository.UniverseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UniverseServiceTests {

    @Mock
    private UniverseRepository universeRepository;

    @Mock
    private UniverseMapper universeMapper;
    @Mock
    private UniverseBOMapper universeBOMapper;
    @Mock
    private UniverseBOService universeBOService;
    @InjectMocks
    private UniverseService universeService;
    private UniverseDE universeDE;

    @BeforeEach
    void setUp() {
        universeDE = UniverseDE.builder()
                .code("M")
                .description("Marvel")
                .build();
    }


    @Test
    void getUniversesTest(){
        Mockito.when(universeRepository.findAll()).thenReturn(List.of(universeDE));

        List<UniverseDTO> universesList = universeService.allUniverses();

        assertThat(universesList).isNotNull();
        assertThat(universesList.size()).isEqualTo(1);
    }

    @Test
    void getNullUniverseTest(){
        Mockito.when(universeRepository.findAll()).thenReturn(Collections.emptyList());

        List<UniverseDTO> universesList = universeService.allUniverses();

        assertThat(universesList).isEmpty();
        assertThat(universesList.size()).isEqualTo(0);

    }

    @Test
    void createUniverseTest(){
        UniverseDTO universeDTO1 = universeMapper.toDTO(universeDE);
        Mockito.when(universeService.createUniverse(universeDTO1)).thenReturn(universeDTO1);

        UniverseDTO universe = universeService.createUniverse(universeDTO1);

        assertThat(universe).isNotNull();
        assertThat(universe.getId()).isEqualTo(1);
    }

}
