package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "study")
@Getter
@Setter
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyId;
    private String studyName;
    private String studyInformation;
    private Date regdate;
}

/*
| study_id          | bigint(20) unsigned | NO   | PRI | NULL              | auto_increment    |
| study_name        | varchar(255)        | NO   |     | NULL              |                   |
| study_information | varchar(255)        | NO   |     | NULL              |                   |
| regdate           | datetime            | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| category_id       | bigint(20) unsigned | NO   | MUL | NULL              |                   |
 */