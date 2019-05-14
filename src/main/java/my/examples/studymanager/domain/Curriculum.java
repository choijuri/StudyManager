package my.examples.studymanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curriculum")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long curriculumId;
    @Lob
    private String curriculumContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_id")
    @JsonIgnore
    private Study study;

    @OneToMany(mappedBy = "curriculum", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<CurriculumDetail> curriculumDetails;
}

/*
| curriculum_id      | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| study_id           | bigint(20) unsigned | NO   | MUL | NULL    |                |
| curriculum_content | longtext            | NO   |     | NULL    |                |
 */