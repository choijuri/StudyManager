package my.examples.studymanager.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class JoinDto {
    @NotNull
    @Email
    @Size(min=10, max=50)
    private String email;
    @NotNull
    @Size(min=4, max=255)
    private String passwd1;
    @NotNull
    @Size(min=4, max=255)
    private String passwd2;
    @NotNull
    @Size(min=11, max = 11)
    @Pattern(regexp = "[0-9]{10,11}")
    private String phone;
    @NotNull
    @Size(min=2, max=255)
    private String name;
}
