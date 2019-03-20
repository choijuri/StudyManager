package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private String messageContent;
    private Date regdate;


    private String receiverId;
    private String senderId;

}
/*
 Field           | Type                | Null | Key | Default           | Extra             |
+-----------------+---------------------+------+-----+-------------------+-------------------+
| message_id      | bigint(20) unsigned | NO   | PRI | NULL              | auto_increment    |
| receiver_id     | varchar(50)         | NO   | MUL | NULL              |                   |
| message_content | longtext            | NO   |     | NULL              |                   |
| regdate         | datetime            | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| sender_id       | varchar(50)         | NO   | MUL | NULL              |                   |
 */