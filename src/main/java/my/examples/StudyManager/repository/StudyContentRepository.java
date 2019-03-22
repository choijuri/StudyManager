package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.StudyContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyContentRepository extends JpaRepository<StudyContent, Long> {
}
