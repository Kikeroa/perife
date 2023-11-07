package com.co.prueba.tecnica.xmen.periferia.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.prueba.tecnica.xmen.periferia.app.models.repository.DNARecordRepository;

@RestController
public class StatsController {

    @Autowired
    private DNARecordRepository dnaRecordRepository;

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStats() {
        long countMutantDNA = dnaRecordRepository.countByIsMutant(true);
        long countHumanDNA = dnaRecordRepository.countByIsMutant(false);

        Map<String, Object> stats = new HashMap<>();
        stats.put("count_mutant_dna", countMutantDNA);
        stats.put("count_human_dna", countHumanDNA);
        stats.put("ratio", countHumanDNA == 0 ? 1.0 : (double) countMutantDNA / countHumanDNA);

        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}
