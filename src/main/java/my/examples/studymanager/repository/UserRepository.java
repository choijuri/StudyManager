package my.examples.studymanager.repository;

import my.examples.studymanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
//    @Modifying
//    @Query("UPDATE User u SET u.passwd =:password WHERE u.userId =:userId")
//    public void modifyPasswordByUserId(@Param("password") String password, @Param("userId") String userId);

    @Query("SELECT u.userId FROM User u")
    public List<String> getAllUserId();


}