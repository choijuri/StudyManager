package my.examples.studymanager.repository;

import my.examples.studymanager.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("SELECT m FROM Message m WHERE m.user.userId =:receiverId")
    public List<Message> getMessageByUser(@Param("receiverId") Long receiverId);

    @Modifying
    @Query("UPDATE Message m SET m.readCount = m.readCount+1 WHERE m.messageId =:messageId")
    public void modifyReadCount(@Param("messageId") Long messageId);

    @Query("SELECT COUNT(m) FROM Message m WHERE m.user.userId=:receiverId AND m.readCount=0")
    public int getNewMessageCount(@Param("receiverId") Long receiverId);


}
