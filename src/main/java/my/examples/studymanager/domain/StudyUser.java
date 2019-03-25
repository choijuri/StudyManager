package my.examples.studymanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "study_user")
@Getter
@Setter
public class StudyUser {
    @EmbeddedId
    private StudyUserId studyUserId;
    @Column(length = 45)
    private String userRole;
}
/*
| Field      | Type                | Null | Key | Default | Extra |
+------------+---------------------+------+-----+---------+-------+
| user_id    | varchar(50)         | NO   | PRI | NULL    |       |
| study_id   | bigint(20) unsigned | NO   | PRI | NULL    |       |
| user_admin | varchar(45)         | NO   |     | NULL    |       |
 */