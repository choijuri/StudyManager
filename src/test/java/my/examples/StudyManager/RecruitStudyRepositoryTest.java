package my.examples.StudyManager;

import my.examples.StudyManager.domain.RecruitStudy;
import my.examples.StudyManager.repository.RecruitStudyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RecruitStudyRepositoryTest {
    @Autowired
    RecruitStudyRepository recruitStudyRepository;

    @Test
    public void init(){ }

    @Test
    public void getRecruitStudy(){
        List<RecruitStudy> recruitStudies = recruitStudyRepository.findAll();
        for(RecruitStudy recruitStudy :recruitStudies) {
            System.out.println(recruitStudy.getRecruitName());
        }
    }

    @Test
    public void getRecuitStudyById(){
        Optional<RecruitStudy> recruitStudy = recruitStudyRepository.findById(1L);
        System.out.println(recruitStudy.get().getRecruitName());
    }


}
