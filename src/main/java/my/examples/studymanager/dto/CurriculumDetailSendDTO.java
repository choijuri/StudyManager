package my.examples.studymanager.dto;

import lombok.*;

import javax.persistence.Lob;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumDetailSendDTO {
    private Long curriculumDetailId;
    @Lob
    private String curriculumDetailContent;
}
