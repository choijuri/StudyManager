package my.examples.StudyManager.repository;

import my.examples.StudyManager.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("SELECT m FROM Message m WHERE m.user.userId =:receiverId")
    public List<Message> getMessageByUser(@Param("receiverId") String receiverId);
}
