package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private int recruitNumbeer;
    private String recruitContent;


    private String userId;
    private Long categoryId;
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
