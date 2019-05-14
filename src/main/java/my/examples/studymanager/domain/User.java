package my.examples.studymanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    @JsonIgnore
    private String passwd;
    @Column(length = 45)
    private String name;
    @Column(length = 11)
    private String phone;
    @ColumnDefault("CURRENT_TIMESTAMP()")
    private Date regdate;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<StudyContent> studyContents;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Comment> comments;

    // 고민하기
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Message> receiveMessages;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Message> sendMessages;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<RecruitStudy> recruitStudies;

    @OneToMany(mappedBy = "studyUserId.user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<StudyUser> studyUsers;

    public User() {
        regdate = new Date();
    }
}

/*
| user_id | varchar(50)  | NO   | PRI | NULL              |                   |
| passwd  | varchar(255) | NO   |     | NULL              |                   |
| phone   | varchar(11)  | NO   |     | NULL              |                   |
| name    | varchar(45)  | NO   |     | NULL              |                   |
| regdate | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
 */