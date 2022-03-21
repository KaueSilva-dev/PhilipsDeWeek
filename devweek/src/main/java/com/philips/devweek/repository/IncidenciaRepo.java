package com.philips.devweek.repository;

import com.philips.devweek.entity.IncidenciaExame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepo extends JpaRepository <IncidenciaExame, Long> {
}
