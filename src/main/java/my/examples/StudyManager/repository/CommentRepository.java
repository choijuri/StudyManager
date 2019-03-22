package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
