package my.examples.studymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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
