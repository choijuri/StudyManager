package my.examples.studymanager.repository;

import my.examples.studymanager.domain.StudyUser;
import my.examples.studymanager.domain.StudyUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyUserRepository extends JpaRepository<StudyUser, StudyUserId> {
    @Query("SELECT su FROM StudyUser su WHERE su.studyUserId.user.userId = :userId")
    public List<StudyUser> getStudyUserByUserId(@Param("userId") Long userId);

    @Query("SELECT su FROM StudyUser su WHERE su.studyUserId.user.userId = :userId AND su.studyUserId.study.studyId = :studyId")
    public StudyUser getStudyUserByUserIdStudyId(@Param("userId") Long userId, @Param("studyId") Long studyId);

}
