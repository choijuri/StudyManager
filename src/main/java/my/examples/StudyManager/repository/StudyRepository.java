package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    @Query("SELECT s FROM Study s INNER JOIN FETCH s.category WHERE s.category.categoryName = :categoryName")
    public List<Study> getStudiesByCategory(@Param("categoryName") String categoryName);
}
