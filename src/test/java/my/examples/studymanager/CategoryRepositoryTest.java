package my.examples.studymanager;

import my.examples.studymanager.domain.Category;
import my.examples.studymanager.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void initTest(){

    }

    @Test
    public void getCategory(){
        List<Category> all = categoryRepository.findAll();
        for(Category category : all){
            System.out.println(category.getCategoryName());
        }

        System.out.println(categoryRepository.findById(1L).get().getCategoryName());
    }

}
