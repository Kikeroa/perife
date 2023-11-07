package com.co.prueba.tecnica.xmen.periferia.app.services;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class MutantDetectorServiceImpl implements IMutantDetectorService{

	@Override
	public boolean isMutant(String[] dna) {
		int n = dna.length;

        return Arrays.stream(dna)
        		.anyMatch(row -> hasMutantSequence(row, "AAAA")) ||  // Verificar horizontal
               IntStream
               .range(0, n)
               .anyMatch(col -> hasMutantSequence(getVerticalSequence(dna, col), "AAAA")) ||  // Verificar vertical
               IntStream
               .range(0, n)
               .anyMatch(row -> IntStream.range(0, n)
            		   .anyMatch(col -> hasMutantSequence(getDiagonalSequence(dna, row, col), "AAAA")));  // Verificar diagonal
	}

	private boolean hasMutantSequence(String sequence, String target) {
        return sequence.contains(target);
    }

    private String getVerticalSequence(String[] dna, int col) {
        StringBuilder vertical = new StringBuilder();
        for (String row : dna) {
            vertical.append(row.charAt(col));
        }
        return vertical.toString();
    }

    private String getDiagonalSequence(String[] dna, int row, int col) {
        StringBuilder diagonal = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (row + i < dna.length && col + i < dna[row].length()) {
                diagonal.append(dna[row + i].charAt(col + i));
            }
        }
        return diagonal.toString();
    }
}
