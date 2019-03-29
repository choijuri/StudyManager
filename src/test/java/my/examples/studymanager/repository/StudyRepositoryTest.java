package my.examples.studymanager.repository;

import my.examples.studymanager.domain.Study;
import my.examples.studymanager.repository.StudyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class StudyRepositoryTest {
    @Autowired
    StudyRepository studyRepository;

    @Test
    public void initTest(){

    }

    @Test
    public void getStudiesByUserId(){
        List<Study> studiesByUserId = studyRepository.getStudiesByUserId(1L);
        for(Study study : studiesByUserId){
            System.out.println(study.getStudyId());
        }
    }

    @Test
    public void getStudiesByUserIdAndCategoryId(){
        List<Study> studiesByUserIdAndCategoryId = studyRepository.getStudiesByUserIdAndCategory(1L,1L);
        for(Study s : studiesByUserIdAndCategoryId){
            System.out.println(s.getStudyName());
        }
    }

    @Test
    public void getStudyByCategory(){
        List<Study> studyList = studyRepository.getStudiesByCategory("IT");
        for (Study study : studyList){
            System.out.println(study.getStudyName());
        }
        System.out.println(studyRepository.getStudiesByCategory("어학").iterator());
    }

//    @Test
//    public void getStudyByEmail(){
//        List<Study> studies = studyRepository.getStudiesAll("urstory@gmail.com");
//        for(Study s : studies){
//            System.out.println("스터디이름 : "+s.getStudyName());
//        }
//    }
}
