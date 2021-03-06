package my.examples.studymanager.dto;


import lombok.*;

import javax.persistence.Lob;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumFormDto {
    @Lob
    private String curriculumContent;
    private Long studyId;
}
