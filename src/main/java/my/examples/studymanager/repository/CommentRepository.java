package my.examples.studymanager.repository;

import my.examples.studymanager.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("SELECT c FROM Comment c WHERE c.studyContent.studyContentId =:studyContentId")
    public List<Comment> getCommentByStudyContentId(@Param("studyContentId") Long studyContentId);
}
