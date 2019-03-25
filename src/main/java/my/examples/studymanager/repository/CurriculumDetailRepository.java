package my.examples.studymanager.repository;

import my.examples.studymanager.domain.CurriculumDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumDetailRepository extends JpaRepository<CurriculumDetail, Long> {
}
