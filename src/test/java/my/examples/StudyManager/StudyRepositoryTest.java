package my.examples.StudyManager;

import my.examples.StudyManager.domain.Study;
import my.examples.StudyManager.repository.StudyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
    public void getStudyByCategory(){
        List<Study> studyList = studyRepository.getStudiesByCategory("IT");
        for (Study study : studyList){
            System.out.println(study.getStudyName());
        }
        System.out.println(studyRepository.getStudiesByCategory("어학").iterator());
    }
}
