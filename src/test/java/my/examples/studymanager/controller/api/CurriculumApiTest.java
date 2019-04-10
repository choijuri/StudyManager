package my.examples.studymanager.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.service.CurriculumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CurriculumApiController.class },includeFilters = @ComponentScan.Filter(classes = {EnableWebSecurity.class}))
public class CurriculumApiTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CurriculumService curriculumService;

    @Test
    public void addCurriculum() throws Exception{
        CurriculumFormDto curriculumFormDto1 = CurriculumFormDto.builder()
                .curriculumContent("테스트 커리큘럼")
                .studyId(2L)
                .build();

        CurriculumFormDto curriculumFormDto2 = CurriculumFormDto.builder()
                .curriculumContent("테스트 커리큘럼2")
                .studyId(2L)
                .build();

        CurriculumFormDto curriculumFormDto3 = CurriculumFormDto.builder()
                .curriculumContent("테스트 커리큘럼3")
                .studyId(2L)
                .build();

        List<CurriculumFormDto> list = new ArrayList<>();
        list.add(curriculumFormDto1);
        list.add(curriculumFormDto2);
        list.add(curriculumFormDto3);

        mockMvc.perform(post("/api/curriculum")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(objectMapper.writeValueAsString(list))
            ).andExpect(status().is(200))
                .andDo(print());
    }

}
