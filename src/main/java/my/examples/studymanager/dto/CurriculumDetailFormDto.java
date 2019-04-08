package my.examples.studymanager.dto;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class CurriculumDetailFormDto {
    private Long curriculumId;
    @Lob
    private String curriculumDetailContent;
}
