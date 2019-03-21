package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    private String userId;
    private String passwd;
    @Column(length = 45)
    private String name;
    @Column(length = 11)
    private String phone;
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
}

/*
| user_id | varchar(50)  | NO   | PRI | NULL              |                   |
| passwd  | varchar(255) | NO   |     | NULL              |                   |
| phone   | varchar(11)  | NO   |     | NULL              |                   |
| name    | varchar(45)  | NO   |     | NULL              |                   |
| regdate | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
 */