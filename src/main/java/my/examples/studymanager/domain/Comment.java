package my.examples.studymanager.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Lob
    private String commentContent;
    @ColumnDefault("CURRENT_TIMESTAMP()")
    private Date regdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_content_id")
    private StudyContent studyContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;

    public Comment() {
        regdate = new Date();
    }
}
/*
 Field            | Type                | Null | Key | Default | Extra |
+------------------+---------------------+------+-----+---------+-------+
| comment_id       | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| comment_content  | longtext            | NO   |     | NULL    |                |
| study_content_id | bigint(20) unsigned | NO   | MUL | NULL    |                |
| writer           | varchar(50)         | NO   | MUL | NULL    |                |
 */
