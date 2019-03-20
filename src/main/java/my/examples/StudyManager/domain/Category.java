package my.examples.StudyManager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(length = 255)
    private String categoryName;

}

/*
| category_id   | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| category_name | varchar(45)         | NO   |     | NULL    |                |
 */