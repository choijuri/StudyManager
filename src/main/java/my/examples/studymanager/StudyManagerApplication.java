package my.examples.studymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
//@EnableAspectJAutoProxy : 스프링이 자동으로 개발자의 메서드를 호출하기 전에 가로챌 수 있게 하는 옵션
//@EnableAspectJAutoProxy : XML로 표현되는 <aop:aspectj-autoproxy> 같은 역할
public class StudyManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyManagerApplication.class, args);
	}

}
