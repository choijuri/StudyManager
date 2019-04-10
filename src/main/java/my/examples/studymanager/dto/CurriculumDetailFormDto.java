package my.examples.studymanager.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Lob;

@Data
@Builder
public class CurriculumDetailFormDto {
    private Long curriculumId;
    @Lob
    private String curriculumDetailContent;
}
