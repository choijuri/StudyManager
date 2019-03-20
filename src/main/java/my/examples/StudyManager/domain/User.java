package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
}

/*
| user_id | varchar(50)  | NO   | PRI | NULL              |                   |
| passwd  | varchar(255) | NO   |     | NULL              |                   |
| phone   | varchar(11)  | NO   |     | NULL              |                   |
| name    | varchar(45)  | NO   |     | NULL              |                   |
| regdate | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
 */