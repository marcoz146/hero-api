package com.bdf.Spring.repository;

import com.bdf.Spring.controller.dto.UniverseDTO;
import com.bdf.Spring.entity.UniverseDE;
import com.bdf.Spring.mapper.UniverseMapper;
import com.bdf.Spring.service.UniverseService;
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
public class UniverseRepositoryTests {

    @Mock
    private UniverseRepository universeRepository;
    @Mock
    private UniverseMapper universeMapper;

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
    void saveUniverseTest() {
        Mockito.when(universeRepository.save(universeDE)).thenReturn(universeDE);

        UniverseDE universeS = universeRepository.save(universeDE);

        assertThat(universeS).isNotNull();
        assertThat(universeS).isEqualTo(universeRepository.save(universeDE));
    }


}
