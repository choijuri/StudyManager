package my.examples.studymanager.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    @ColumnDefault("CURRENT_TIMESTAMP()")
    private Date regdate;

    @ColumnDefault("0")
    private int readCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User user1;

    public Message(){
        regdate = new Date();
        this.readCount = 0;
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