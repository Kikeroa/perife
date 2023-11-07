package com.co.prueba.tecnica.xmen.periferia.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.prueba.tecnica.xmen.periferia.app.models.entity.DNARecord;
import com.co.prueba.tecnica.xmen.periferia.app.models.repository.DNARecordRepository;
import com.co.prueba.tecnica.xmen.periferia.app.services.IMutantDetectorService;


@RestController
public class MutanteController {

    @Autowired
    private DNARecordRepository dnaRecordRepository;
    
    @Autowired
    private IMutantDetectorService IMutantDetectorService;

    @PostMapping("/mutante")
    public ResponseEntity<String> detectMutant(@RequestBody Map<String, Object> payload) {
        List<String> dnList= (List<String>) payload.get("dna");
    	String[] dna = dnList.toArray(new String[0]);
        boolean isMutant = IMutantDetectorService.isMutant(dna);

        DNARecord dnaRecord = new DNARecord(dna, isMutant);
        dnaRecordRepository.save(dnaRecord);

        if (isMutant) {
            return new ResponseEntity<>("Mutant detected", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Human detected", HttpStatus.FORBIDDEN);
        }
    }
}
