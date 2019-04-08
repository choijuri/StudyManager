package my.examples.studymanager.dto;


import lombok.Data;

import javax.persistence.Lob;

@Data
public class CurriculumFormDto {
    @Lob
    private String curriculumContent;
    private Long studyId;
}
