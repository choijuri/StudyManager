package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
