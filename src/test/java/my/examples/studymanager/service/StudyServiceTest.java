package my.examples.studymanager.service;


import my.examples.studymanager.domain.Study;
import my.examples.studymanager.dto.StudyFormDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyServiceTest {

    @Autowired(required = true)
    StudyService studyService;

    @Test
    public void getstudyId(){
        StudyFormDto studyFormDto = new StudyFormDto();
        studyFormDto.setCategoryId(1L);
        studyFormDto.setStudyInformation("제발 되라");
        studyFormDto.setStudyName("제발 ㅠㅠㅠ");
        Long id = studyService.addStudy(studyFormDto);
        System.out.println(id);
    }

    @Test
    public void getStudiesByUser(){
        List<Study> studiesByUser = studyService.getStudiesByUser(1L);
        for(Study s : studiesByUser){
            System.out.println(s.getStudyName());
        }
    }

}
