package com.co.prueba.tecnica.xmen.periferia.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.co.prueba.tecnica.xmen.periferia.app.services.IMutantDetectorService;

@SpringBootTest
class PruebaTecnicaXmenPeriferiaApplicationTests {

	 @MockBean
	    private IMutantDetectorService mutantDetectorService;

	
	@Test
	void contextLoads() {
	}

    @Test
    public void testIsMutant() {
        String[] mutantDna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        when(mutantDetectorService.isMutant(mutantDna)).thenReturn(true);
        assertTrue(mutantDetectorService.isMutant(mutantDna));

        String[] humanDna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTA"};
        when(mutantDetectorService.isMutant(humanDna)).thenReturn(false);
        assertFalse(mutantDetectorService.isMutant(humanDna));
    }
}
