package my.examples.studymanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private Long userId;
    private String content;
    private Long studyContentId;
}
