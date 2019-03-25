package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.RecruitStudy;
import my.examples.StudyManager.repository.custom.RecruitStudyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitStudyRepository extends JpaRepository<RecruitStudy, Long>, RecruitStudyRepositoryCustom {
}
