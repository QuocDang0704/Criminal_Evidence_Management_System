package fis.quocdb3.repository;

import fis.quocdb3.domain.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {
}
