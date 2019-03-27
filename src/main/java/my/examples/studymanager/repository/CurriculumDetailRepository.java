package my.examples.studymanager.repository;

import my.examples.studymanager.domain.CurriculumDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurriculumDetailRepository extends JpaRepository<CurriculumDetail, Long> {

    @Query("SELECT cd FROM CurriculumDetail cd WHERE cd.curriculum.curriculumId =:curriculumId")
    public List<CurriculumDetail> getCurriculumDetailsByCurriculumId(@Param("curriculumId") Long curriculumId);

}
