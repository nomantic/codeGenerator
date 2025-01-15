package com.fiscal.codeGenerator.repository;

import com.fiscal.codeGenerator.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationRepository extends JpaRepository<Nation, String> {
}
