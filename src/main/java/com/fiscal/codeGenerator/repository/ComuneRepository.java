package com.fiscal.codeGenerator.repository;

import com.fiscal.codeGenerator.entity.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComuneRepository extends JpaRepository<Comune, String> {
}
