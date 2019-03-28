package my.examples.studymanager;

import my.examples.studymanager.domain.StudyUser;
import my.examples.studymanager.domain.StudyUserId;
import my.examples.studymanager.repository.StudyRepository;
import my.examples.studymanager.repository.StudyUserRepository;
import my.examples.studymanager.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class StudyUserRepositoryTest {
    @Autowired
    StudyUserRepository studyUserRepository;

    @Autowired
    StudyRepository studyRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void initTest(){

    }

    @Test
    public void getStudyUser(){
        List<StudyUser> studyUsers = studyUserRepository.getStudyUserByUserId(1L);
        for (StudyUser studyUser : studyUsers){
            System.out.println(studyUser.getStudyUserId());
        }
    }

//    @Test
//    public void getStudyUser2(){
//       StudyUser studyUsers = studyUserRepository.getStudyUserByUserIdStudyId(1L,3L);
//        for (StudyUser studyUser : studyUsers){
//            System.out.println(studyUser.getStudyUserId());
//        }
//    }

    @Test
    @Transactional
    public void deleteTest(){
        StudyUserId studyUserId;
//        studyUserId.setStudy(studyRepository.getOne(5L));
//        studyUserId.setUser(userRepository.getOne(5L));
//        studyUserRepository.getStudyUserByUserIdStudyId(2L,5L)
//        studyUserRepository.deleteById(studyUserId);
        studyUserRepository.delete(studyUserRepository.getStudyUserByUserIdStudyId(3L,5L));
    }

}
