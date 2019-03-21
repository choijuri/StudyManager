package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
