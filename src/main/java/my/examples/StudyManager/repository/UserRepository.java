package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
