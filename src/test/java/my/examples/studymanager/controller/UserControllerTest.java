package my.examples.studymanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.examples.studymanager.controller.api.CurriculumDetailApiController;
import my.examples.studymanager.domain.User;
import my.examples.studymanager.dto.JoinFormDto;
import my.examples.studymanager.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {UserController.class},includeFilters = @ComponentScan.Filter(classes = {EnableWebSecurity.class}))
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserService userService;

    @Test
    public void joinTest() throws Exception{
        JoinFormDto joinFormDto = JoinFormDto.builder()
                .email("hong@gmail.com")
                .passwd1("12341234")
                .passwd2("12341234")
                .phone("01011113333")
                .name("홍이장")
                .build();

        User user = User.builder()
                .email(joinFormDto.getEmail())
                .name(joinFormDto.getName())
                .passwd(joinFormDto.getPasswd1())
                .phone(joinFormDto.getPhone())
                .build();

        Mockito.when(userService.addUser(user)).thenReturn(user);

        mockMvc.perform(put("/users/join")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(joinFormDto))
                ).andExpect(status().is(200))
//        )
                .andDo(print()); // 값을 출력할 수 있다.
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("userId").exists()); // id가존재한다.
    }
}
/*
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
 */