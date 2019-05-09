package my.examples.studymanager.repository;

import my.examples.studymanager.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    @Query("SELECT s FROM Study s INNER JOIN FETCH s.category WHERE s.category.categoryName = :categoryName")
    public List<Study> getStudiesByCategory(@Param("categoryName") String categoryName);

    @Query("SELECT distinct s FROM Study s, StudyUser su, User u INNER JOIN FETCH s.category WHERE s.studyId = su.studyUserId.study.studyId and " +
            "su.studyUserId.user.userId = u.userId and u.userId = :userId")
    public List<Study> getStudiesByUserId(@Param("userId") Long userId);

    @Query("SELECT distinct s FROM Study s, StudyUser su, User u INNER JOIN FETCH s.category WHERE s.studyId = su.studyUserId.study.studyId and " +
            "su.studyUserId.user.userId = u.userId and u.userId = :userId and s.category.categoryId =:categoryId")
    public List<Study> getStudiesByUserIdAndCategory(@Param("userId") Long userId, @Param("categoryId") Long categoryId);

    @Query("SELECT s FROM Study s INNER JOIN s.studyUsers su INNER JOIN su.studyUserId sui INNER JOIN sui.user u WHERE u.userId =:userId")
    public List<Study> getStudiesByUser(@Param("userId") Long userId);

    @Query("SELECT s FROM Study s INNER JOIN s.studyUsers su INNER JOIN su.studyUserId sui INNER JOIN sui.user u INNER JOIN s.category c " +
            "WHERE u.userId =:userId AND c.categoryId =:categoryId")
    public List<Study> getStudiesByUserIdCategoryId(@Param("userId") Long userId, @Param("categoryId") Long categoryId);

    @Query("SELECT count(s.code) FROM Study s WHERE s.code = :code")
    public int codeCheck(@Param("code") String code);

    @Query("SELECT s FROM Study s WHERE s.code = :code")
    public Study getStudyByCode(@Param("code") String code);

}
