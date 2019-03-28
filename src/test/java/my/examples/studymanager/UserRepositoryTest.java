package my.examples.studymanager;

import my.examples.studymanager.domain.User;
import my.examples.studymanager.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void initTest(){
    }

    //모든 유저 가져오기
    @Test
    public void getUserAll(){
        List<User> users = userRepository.findAll();
        for(User user: users){
            System.out.println(user.getName());
        }
    }

    //userId로 해당 user가져오기 (1건)
    @Test
    public void getUserByUserId(){
        User user = userRepository.findById(1L).get();
        System.out.println(user.getName());
    }

    //userId를 가져와서 동일한 유저 유무 확인하기
    @Test
    public void getUserEmail(){
        List<String> allUserEmail = userRepository.getAllUserEmail();
        for(String userEmail : allUserEmail){
            System.out.println(userEmail);
            if(userEmail.equals("jh123@gmail.com")){
                System.out.println("사용불가능한 아이디입니다.");
                break;
            }else{
                System.out.println("사용 가능한 아이디입니다.");
            }
        }
    }

    //해당 유저의 passwd수정하기
    @Test
    @Rollback(false)
    @Transactional
    public void modifyUserPassword() throws Exception{
        //userRepository.modifyPasswordByUserId("12345","yw123@gmail.com");
        User user = userRepository.findById(4L).get();
        user.setPasswd("123456");
    }

}
