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
    @Size(min=10, max=50)
    private String recruitName;
    @NotNull
    @Size(min=5, max=50)
    private String location;
    @NotNull
    @Size(min=1, max=50)
    private int recruitNumber;
    @NotNull
    @Size(min=1, max=255)
    private String recruitContent;
    @NotNull
    private Long categoryId;
}
