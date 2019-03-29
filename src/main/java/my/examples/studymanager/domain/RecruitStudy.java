package my.examples.studymanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recruit_study")
@Getter
@Setter
public class RecruitStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitId;
    @Column(length = 45)
    private String recruitName;
    private String location;
    private int recruitNumber;
    @Lob
    private String recruitContent;
    private Date regdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public RecruitStudy() {
        regdate = new Date();
    }
}
/*
 Field           | Type                | Null | Key | Default | Extra          |
+-----------------+---------------------+------+-----+---------+----------------+
| recruit_id      | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| recruit_name    | varchar(45)         | NO   |     | NULL    |                |
| location        | varchar(255)        | NO   |     | NULL    |                |
| recruit_number  | int(11)             | NO   |     | NULL    |                |
| recruit_content | longtext            | NO   |     | NULL    |                |
| user_id         | varchar(50)         | NO   | PRI | NULL    |                |
| category_id     | bigint(20) unsigned | NO   | PRI | NULL    |                |
+-----------------+---------------------+------+-----+---------+----------------+
 */
