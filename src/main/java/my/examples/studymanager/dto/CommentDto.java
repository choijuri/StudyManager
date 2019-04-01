package my.examples.studymanager.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long userId;
    private String content;
    private Long studyContentId;
}
