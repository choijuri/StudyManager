package my.examples.studymanager.repository;

import my.examples.studymanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Modifying
//    @Query("UPDATE User u SET u.passwd =:password WHERE u.userId =:userId")
//    public void modifyPasswordByUserId(@Param("password") String password, @Param("userId") String userId);

    @Query("SELECT u.email FROM User u")
    public List<String> getAllUserEmail();

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    @Query("SELECT count(u.email) FROM User u WHERE u.email = :email")
    public int emailChk(@Param("email") String email);

    @Query("SELECT u.userId FROM User u WHERE u.email = :email")
    public Long getUserIdByEmail(@Param("email") String email);
}
