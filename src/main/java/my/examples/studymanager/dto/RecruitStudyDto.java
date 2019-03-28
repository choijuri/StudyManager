package my.examples.studymanager.dto;

import lombok.Data;

@Data
public class RecruitStudyDto {
    private String recruitName;
    private String location;
    private int recruitNumber;
    private String recruitContent;
    private Long categoryId;
}
