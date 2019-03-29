package my.examples.studymanager.repository;

import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.repository.RecruitStudyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

    @Test
    public void getRecruitStudyByLocation() throws Exception{
        long count =
                recruitStudyRepository.getRecruitStudyCount(1L,null, null);
        System.out.println(count);
        List<RecruitStudy> recruitStudies =
                recruitStudyRepository.getRecruitStudy(null, 0, 5,
                        "RECRUITSTUDYLOCATION_SEARCH", "강남");

        for(RecruitStudy recruitStudy : recruitStudies)
            System.out.println("스터디 이름 : "+recruitStudy.getRecruitName()+" , 위치 : "+recruitStudy.getLocation());
    }

    @Test
    public void getRecruitStudyByName() throws Exception{
        long count =
                recruitStudyRepository.getRecruitStudyCount(1L,null, null);
        System.out.println(count);
        List<RecruitStudy> recruitStudies =
                recruitStudyRepository.getRecruitStudy(null, 0, 5,
                        "RECRUITSTUDYNAME_SEARCH", "java");

        for(RecruitStudy recruitStudy : recruitStudies)
            System.out.println("스터디 이름 : "+recruitStudy.getRecruitName()+" , 위치 : "+recruitStudy.getLocation());
    }





}
