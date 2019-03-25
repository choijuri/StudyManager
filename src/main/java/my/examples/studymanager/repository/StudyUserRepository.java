package my.examples.studymanager.repository;

import my.examples.studymanager.domain.StudyUser;
import my.examples.studymanager.domain.StudyUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyUserRepository extends JpaRepository<StudyUser, StudyUserId> {
}
