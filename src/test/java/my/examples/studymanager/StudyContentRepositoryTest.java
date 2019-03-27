package my.examples.studymanager;

import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.repository.StudyContentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class StudyContentRepositoryTest {
    @Autowired
    StudyContentRepository studyContentRepository;

    @Test
    public void initTest() {

    }

    @Test
    public void getStudyContentByCurriculumDetailId() {
//        studyContentRepository.findAll();
        System.out.println(studyContentRepository.getStudyContentByCurriculumDetailId(1L).getContent());
//        studyContentRepository.getStudyContentByCurriculumDetailId(1L);
    }


    @Test
    public void getStudyContentByUserId(){

        List<StudyContent> studyContents = studyContentRepository.getStudyContentByUserId(1L);
        for (StudyContent studyContent : studyContents){
            System.out.println(studyContent.getContent());
        }
        System.out.println();
    }

}
