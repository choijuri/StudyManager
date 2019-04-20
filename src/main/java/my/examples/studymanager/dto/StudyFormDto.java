package my.examples.studymanager.dto;

import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyFormDto {
    @NotNull
    @Size(min=2, max=255)
    private String studyName;
    @NotNull
    @Lob
    private String studyInformation;
    @NotNull
    private Long categoryId;
}
