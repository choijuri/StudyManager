package my.examples.studymanager.repository;


import my.examples.studymanager.domain.CurriculumDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CurriculumDetailRepositoryTest {
    @Autowired
    CurriculumDetailRepository curriculumDetailRepository;

    @Test
    public void getCurriculumDetail(){
        List<CurriculumDetail> curriculumDetails = curriculumDetailRepository.getCurriculumDetailsByCurriculumId(7L);
        for (CurriculumDetail c : curriculumDetails){
            System.out.println(c.getCurriculumDetailContent());
        }
    }
}
