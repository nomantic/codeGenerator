package com.fiscal.codeGenerator.repository;

import com.fiscal.codeGenerator.entity.ValidComune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidComuneRepository extends JpaRepository<ValidComune, Long> {
    List<ValidComune> getValidComuneByPlaceName(String comune);
}
