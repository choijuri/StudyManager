package my.examples.studymanager.repository;

import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.repository.custom.RecruitStudyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitStudyRepository extends JpaRepository<RecruitStudy, Long>, RecruitStudyRepositoryCustom {
}
