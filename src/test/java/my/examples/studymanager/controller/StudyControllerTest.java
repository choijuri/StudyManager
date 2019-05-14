//package my.examples.studymanager.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import my.examples.studymanager.domain.*;
//import my.examples.studymanager.service.StudyService;
//import my.examples.studymanager.service.StudyUserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.MediaType;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.util.DateUtil.now;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = {StudyController.class },includeFilters = @ComponentScan.Filter(classes = {EnableWebSecurity.class}))
//public class StudyControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @MockBean
//    StudyService studyService;
//
//    @MockBean
//    StudyUserService studyUserService;
//
//
//    @Test
//    @WithMockUser(username = "urstory@gmail.com", authorities = {"ROLE_ADMIN"})
//    public void getStudies() throws Exception{
//        Curriculum curriculum1 = Curriculum.builder()
//                                .curriculumId(1L)
//                                .curriculumContent("java 공부1")
//                                .curriculumDetails(null)
//                                .build();
//
//        Curriculum curriculum2 = Curriculum.builder()
//                .curriculumId(2L)
//                .curriculumContent("java 공부2")
//                .curriculumDetails(null)
//                .build();
//
//        List<Curriculum> curriculumList = new ArrayList<>();
//        curriculumList.add(curriculum1);
//        curriculumList.add(curriculum2);
//
//        Category category = Category.builder()
//                                    .categoryId(1L)
//                                    .categoryName("IT")
//                                    .build();
//
//        User user = User.builder()
//                    .userId(1L)
//                    .email("urstory@gmail.com")
//                    .name("toto")
//                    .passwd("1234")
//                    .phone("01039334563")
//                    .build();
//
//        Study study = Study.builder()
//                    .studyId(1L)
//                    .studyInformation("자바 스터디")
//                    .studyName("java study")
//                    .category(category)
//                    .regdate(now())
//                    .curriculumList(curriculumList)
//                    .build();
//
//        StudyUserId studyUserId = StudyUserId.builder()
//                                                .study(study)
//                                                .user(user)
//                                                .build();
//
//        StudyUser studyUser = StudyUser.builder()
//                                    .studyUserId(studyUserId)
//                                    .userRole("ADMIN")
//                                    .build();
//
//        List<Study> studyList = new ArrayList<>();
//        studyList.add(study);
//
//
//        Mockito.when(studyService.getStudiesByUser(user.getUserId())).thenReturn(studyList);
//
//        mockMvc.perform(get("/study/list")
//                    .accept(MediaType.APPLICATION_JSON_UTF8))
////                    .andExpect(status().isOk())
//                    .andDo(print());
//
//    }
//
//
//
//}
