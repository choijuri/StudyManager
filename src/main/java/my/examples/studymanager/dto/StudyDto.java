package my.examples.studymanager.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyDto {
    private Long studyId;
    private String studyName;
    private String studyInformation;
}
