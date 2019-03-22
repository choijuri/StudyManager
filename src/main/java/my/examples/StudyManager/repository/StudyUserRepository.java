package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.StudyUser;
import my.examples.StudyManager.domain.StudyUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyUserRepository extends JpaRepository<StudyUser, StudyUserId> {
}
