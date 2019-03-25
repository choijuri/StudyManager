package my.examples.studymanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "study_content")
@Getter
@Setter
public class StudyContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyContentId;
    @Lob
    @Column(name="content")
    private String content;
    private Date regdate;

    @OneToMany(mappedBy = "studyContent", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User user;

    @OneToMany(mappedBy = "studyContent", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ImageFile> imageFiles;

    @OneToOne
    @JoinColumn(name = "curriculum_detail_id")
    private CurriculumDetail curriculumDetail;
}

/*
| study_content_id     | bigint(20) unsigned | NO   | PRI | NULL              | auto_increment    |
| curriculum_detail_id | bigint(20) unsigned | NO   | MUL | NULL              |                   |
| content              | longtext            | NO   |     | NULL              |                   |
| regdate              | datetime            | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| writer               | varchar(50)         | NO   | MUL | NULL              |                   |
 */