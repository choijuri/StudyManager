package my.examples.studymanager.service;

import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.repository.CategoryRepository;
import my.examples.studymanager.repository.RecruitStudyRepository;
import my.examples.studymanager.repository.UserRepository;
import my.examples.studymanager.service.RecruitStudyService;
import my.examples.studymanager.service.RecruitStudyServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJpaTest
public class RecruitStudyServiceTest {
//    @Autowired(required = true)
//    RecruitStudyRepository recruitStudyRepository;
//    @Autowired(required = true)
//    UserRepository userRepository;
//    @Autowired(required = true)
//    CategoryRepository categoryRepository;
    @Autowired(required = true)
    RecruitStudyService recruitStudyService;

//    @Before
//    public void initTest(){
//        recruitStudyService = new RecruitStudyServiceImpl(recruitStudyRepository,userRepository,categoryRepository);
//    }

    @Test
    @Transactional(readOnly = true)
    public void getRecruitStudy() throws Exception{
        System.out.println(recruitStudyService.getRecruitStudy(2L).getUser());
    }

    @Test
    public void getRecruitStudyAll(){
        List<RecruitStudy> recruitStudyAll = recruitStudyService.getRecruitStudyAll();
        for (RecruitStudy recruitStudy : recruitStudyAll){
            System.out.println(recruitStudy.getRecruitName());
        }
    }
}
