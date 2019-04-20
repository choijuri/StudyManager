package my.examples.studymanager.dto;

import lombok.*;

import javax.persistence.Lob;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumDetailFormDto {
    private Long curriculumId;
    @Lob
    private String curriculumDetailContent;
}
