package my.examples.studymanager.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.examples.studymanager.controller.MessageController;
import my.examples.studymanager.domain.CurriculumDetail;
import my.examples.studymanager.dto.CurriculumDetailFormDto;
import my.examples.studymanager.repository.CurriculumRepository;
import my.examples.studymanager.service.CurriculumDetailService;
import net.sf.json.JSONArray;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CurriculumDetailApiController.class },includeFilters = @ComponentScan.Filter(classes = {EnableWebSecurity.class}))
public class CurriculumDetailApiControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

//    @Autowired
//    CurriculumRepository curriculumRepository;

    @MockBean
    CurriculumDetailService curriculumDetailService;
//
//    @MockBean
//    MessageController messageController;

    @Test
    public void createCurriculumDetail() throws Exception{
        List<CurriculumDetailFormDto> list = new ArrayList<>();
        CurriculumDetailFormDto curriculumDetailFormDto = CurriculumDetailFormDto.builder()
                                                                    .curriculumId(1L)
                                                                    .curriculumDetailContent("안녕하세요")
                                                                    .build();

        list.add(curriculumDetailFormDto);

        List<CurriculumDetailFormDto> curriculumDetailList = JSONArray.fromObject(list);
        Mockito.when(curriculumDetailService.addCurriculumDetail(curriculumDetailList)).thenReturn(true);

        mockMvc.perform(post("/api/curriculumDetail")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(list))
                ).andExpect(status().is(200))
//        )
                .andDo(print()); // 값을 출력할 수 있다.
//                .andExpect(status().isCreated());
//                .andExpect(jsonPath("curriculumDetailId").exists());
    }

}
