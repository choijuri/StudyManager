package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
