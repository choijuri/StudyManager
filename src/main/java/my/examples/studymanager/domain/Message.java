package my.examples.studymanager.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    @Lob
    private String messageContent;
    private Date regdate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User user1;

    public Message(){
        regdate = new Date();
    }
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