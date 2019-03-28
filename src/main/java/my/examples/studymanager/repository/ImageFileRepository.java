package my.examples.studymanager.repository;

import my.examples.studymanager.domain.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
    @Query("SELECT i FROM ImageFile i WHERE i.studyContent.studyContentId =:studyContentId")
    public List<ImageFile> getImageFilesByStudyConetentId(@Param("studyContentId") Long studyContentId);
}
