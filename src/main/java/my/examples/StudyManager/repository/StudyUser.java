package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.StudyUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyUser extends JpaRepository<StudyUser, StudyUserId> {
}
