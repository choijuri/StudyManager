package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "study_content")
@Getter
@Setter
public class StudyContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyContentId;
    private String content;
    private Date regdate;

}

/*
| study_content_id     | bigint(20) unsigned | NO   | PRI | NULL              | auto_increment    |
| curriculum_detail_id | bigint(20) unsigned | NO   | MUL | NULL              |                   |
| content              | longtext            | NO   |     | NULL              |                   |
| regdate              | datetime            | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| writer               | varchar(50)         | NO   | MUL | NULL              |                   |
 */