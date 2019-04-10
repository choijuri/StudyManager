package my.examples.studymanager.controller.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import my.examples.studymanager.dto.EmailCheckDto;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {EmailCheckApiController.class },includeFilters = @ComponentScan.Filter(classes = {EnableWebSecurity.class}))
public class EmailCheckApiControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserService userService;

    @Test
    public void EmailCheck() throws Exception{
        EmailCheckDto emailCheckDto = EmailCheckDto.builder()
                                        .email("urstory@gamil.com")
                                        .build();

        Mockito.when(userService.emailChk(emailCheckDto.getEmail())).thenReturn(0);
        mockMvc.perform(post("/api/emailCheck")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(emailCheckDto))
        )
                .andDo(print()); // 값출력
    }



}
