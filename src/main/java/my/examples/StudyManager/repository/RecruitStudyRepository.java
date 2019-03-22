package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.RecruitStudy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitStudyRepository extends JpaRepository<RecruitStudy, Long> {
}
