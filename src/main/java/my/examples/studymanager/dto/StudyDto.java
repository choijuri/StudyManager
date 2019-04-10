package my.examples.studymanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudyDto {
    private Long studyId;
    private String studyName;
    private String studyInformation;
}
