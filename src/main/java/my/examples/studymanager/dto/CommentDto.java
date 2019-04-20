package my.examples.studymanager.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long userId;
    private String content;
    private Long studyContentId;
}
