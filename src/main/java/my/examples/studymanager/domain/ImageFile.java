package my.examples.studymanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "image_file")
@Setter
@Getter
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageFileId;
    private Long length;
    private String mimeType;
    private int ordering;
    private String name;
    private String saveFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_content_id")
    private StudyContent studyContent;
}
/*
+------------------+---------------------+------+-----+---------+----------------+
| Field            | Type                | Null | Key | Default | Extra          |
+------------------+---------------------+------+-----+---------+----------------+
| image_file_id    | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| length           | bigint(20) unsigned | NO   |     | NULL    |                |
| mime_type        | varchar(255)        | NO   |     | NULL    |                |
| ordering         | int(11)             | NO   |     | NULL    |                |
| name             | varchar(255)        | NO   |     | NULL    |                |
| study_content_id | bigint(20) unsigned | NO   | MUL | NULL    |                |
| save_file_name   | varchar(255)        | NO   |     | NULL    |                |
+------------------+---------------------+------+-----+---------+----------------+
 */
