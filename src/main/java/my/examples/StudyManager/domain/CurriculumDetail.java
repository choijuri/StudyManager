package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "curriculum_detail")
@Getter
@Setter
public class CurriculumDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long curriculumDetailId;
    private String curriculumContent;
}

/*
| curriculum_detail_id      | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| curriculum_id             | bigint(20) unsigned | NO   | MUL | NULL    |                |
| curriculum_detail_content | longtext            | NO   |     | NULL    |                |
 */