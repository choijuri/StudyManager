package my.examples.studymanager.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class StudyFormDto {
    @NotNull
    @Size(min=2, max=255)
    private String studyName;
    @NotNull
    @Lob
    private String studyInformation;
    @NotNull
    @Size(min=1, max=2)
    private Long categoryId;
}
