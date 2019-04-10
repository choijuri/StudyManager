package my.examples.studymanager.dto;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Lob;

@Data
@Builder
public class CurriculumFormDto {
    @Lob
    private String curriculumContent;
    private Long studyId;
}
