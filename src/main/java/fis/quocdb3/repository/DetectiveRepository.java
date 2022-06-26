package fis.quocdb3.repository;

import fis.quocdb3.domain.Detective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectiveRepository extends JpaRepository<Detective, Long> {
    Detective findDetectiveByPersonUsername(String username);
}
