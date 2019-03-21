package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curriculum")
@Getter
@Setter
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long curriculumId;
    private String curriculumContent;

    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study;

    @OneToMany(mappedBy = "curriculum", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<CurriculumDetail> curriculumDetails;
}

/*
| curriculum_id      | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| study_id           | bigint(20) unsigned | NO   | MUL | NULL    |                |
| curriculum_content | longtext            | NO   |     | NULL    |                |
 */