package my.examples.studymanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailCheckDto {
    private String email;
}
