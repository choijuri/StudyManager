package my.examples.studymanager.repository;

import my.examples.studymanager.domain.StudyContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyContentRepository extends JpaRepository<StudyContent, Long> {

    @Query("SELECT sc FROM StudyContent sc INNER JOIN FETCH sc.curriculumDetail WHERE sc.curriculumDetail.curriculumDetailId = :curriculumDetailId")
    public StudyContent getStudyContentByCurriculumDetailId(@Param("curriculumDetailId") Long curriculumDetailId);

    @Query("SELECT sc FROM StudyContent sc INNER JOIN FETCH sc.user WHERE sc.user.userId = :userId")
    public List<StudyContent> getStudyContentByUserId(@Param("userId") String userId);
}
