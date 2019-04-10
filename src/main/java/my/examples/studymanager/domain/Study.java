package my.examples.studymanager.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "study")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyId;
    private String studyName;
    @Column(columnDefinition = "TEXT")
    private String studyInformation;
    private Date regdate;

    @OneToMany(mappedBy = "study", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Curriculum> curriculumList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "studyUserId.study", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<StudyUser> studyUsers;

    public Study() {
        regdate = new Date();
    }
}

/*
| study_id          | bigint(20) unsigned | NO   | PRI | NULL              | auto_increment    |
| study_name        | varchar(255)        | NO   |     | NULL              |                   |
| study_information | varchar(255)        | NO   |     | NULL              |                   |
| regdate           | datetime            | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| category_id       | bigint(20) unsigned | NO   | MUL | NULL              |                   |
 */