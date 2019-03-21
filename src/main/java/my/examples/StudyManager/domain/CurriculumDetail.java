package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "curriculum_detail")
@Getter
@Setter
public class CurriculumDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long curriculumDetailId;
    @Lob
    private String curriculumDetailContent;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;
}

/*
| curriculum_detail_id      | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| curriculum_id             | bigint(20) unsigned | NO   | MUL | NULL    |                |
| curriculum_detail_content | longtext            | NO   |     | NULL    |                |
 */