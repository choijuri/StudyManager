package my.examples.studymanager.repository;

import my.examples.studymanager.domain.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {

    @Query("SELECT c FROM Curriculum c WHERE c.study.studyId =:studyId")
    public List<Curriculum> getCurriculumByStudyId(@Param("studyId") Long studyId);

    @Modifying
    @Query("UPDATE Curriculum c SET c.curriculumContent =:curriculumContent WHERE c.curriculumId =:curriculumId")
    public void modifyCurriculum(@Param("curriculumContent") String curriculumContent, @Param("curriculumId") Long curriculumId);

    @Query("SELECT c FROM Curriculum c INNER JOIN c.curriculumDetails cd WHERE cd.curriculumDetailId= :curriculumDetailId")
    public Curriculum getCurriculumBycurriculumDetailId(@Param("curriculumDetailId") Long curriculumDetailId);
}
