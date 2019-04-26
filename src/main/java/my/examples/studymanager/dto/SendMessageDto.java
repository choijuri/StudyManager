package my.examples.studymanager.dto;

import lombok.*;

import javax.persistence.Lob;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageDto {
    private Long sender;
    private Long receiver;
    @Lob
    private String messageContent;
}
