package my.examples.StudyManager;


import my.examples.StudyManager.domain.Curriculum;
import my.examples.StudyManager.repository.CurriculumRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CurriculumRepositoryTest {
    @Autowired
    CurriculumRepository curriculumRepository;

    @Test
    public void initTest(){

    }

    @Test
    public void getOne(){
        System.out.println(curriculumRepository.getOne(1L).getCurriculumContent());
    }

    @Test
    public void getCurriculumByStudyId(){
        List<Curriculum> curricula = curriculumRepository.getCurriculumByStudyId(4L);
        for (Curriculum curriculum : curricula){
            System.out.println(curriculum.getCurriculumContent());
        }
    }

    @Test
    public void modifyCurriculum(){
        System.out.println(curriculumRepository.findById(4L).get().getCurriculumContent());
        curriculumRepository.modifyCurriculum("절차지향",4L);
        System.out.println(curriculumRepository.getOne(4L).getCurriculumContent());

        Curriculum curriculum = curriculumRepository.getOne(4L);
        curriculum.setCurriculumContent("객체지향");
        System.out.println(curriculum.getCurriculumContent());
    }
}
