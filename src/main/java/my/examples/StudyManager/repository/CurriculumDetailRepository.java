package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.CurriculumDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumDetailRepository extends JpaRepository<CurriculumDetail, Long> {
}
