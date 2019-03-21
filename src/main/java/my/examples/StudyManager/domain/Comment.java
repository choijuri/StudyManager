package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentContent;
    @Column(length = 50)
    private String writer;

    @ManyToOne
    @JoinColumn(name = "study_content_id")
    private StudyContent studyContent;

}
/*
 Field            | Type                | Null | Key | Default | Extra |
+------------------+---------------------+------+-----+---------+-------+
| comment_id       | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| comment_content  | longtext            | NO   |     | NULL    |                |
| study_content_id | bigint(20) unsigned | NO   | MUL | NULL    |                |
| writer           | varchar(50)         | NO   | MUL | NULL    |                |
 */
