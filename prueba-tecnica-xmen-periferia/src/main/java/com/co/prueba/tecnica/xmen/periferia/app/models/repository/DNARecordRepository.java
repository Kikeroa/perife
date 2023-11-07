package com.co.prueba.tecnica.xmen.periferia.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.prueba.tecnica.xmen.periferia.app.models.entity.DNARecord;

public interface DNARecordRepository extends JpaRepository<DNARecord, Long> {

	long countByIsMutant(boolean isMutant);
}
