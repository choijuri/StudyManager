package my.examples.studymanager.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitStudyDto {
    @NotNull
    @Size(min=2, max=50)
    private String recruitName;
    @NotNull
    @Size(min=2, max=50)
    private String sido1;
    @NotNull
    @Size(min=2, max=50)
    private String gugun1;
    @NotNull
    private int recruitNumber;
    @NotNull
    @Size(min=1, max=255)
    private String recruitContent;
    @NotNull
    private Long categoryId;
}
