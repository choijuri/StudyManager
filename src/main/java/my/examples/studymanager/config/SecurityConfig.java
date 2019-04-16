package my.examples.studymanager.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// spring security 설정 파일은 보통
// WebSecurityConfigurerAdapter 를 상속받아서 만든다.
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 아예 인가처리를 하지 않는 (무시하는 URL설정) - 이미지 or css, javascript
    @Override
    public void configure(WebSecurity web) throws Exception {

//    PathRequest.toStaticResources().atCommonLocations()
//    CSS(new String[]{"/css/**"}),
//    JAVA_SCRIPT(new String[]{"/js/**"}),
//    IMAGES(new String[]{"/images/**"}),
//    WEB_JARS(new String[]{"/webjars/**"}),
//    FAVICON(new String[]{"/**/favicon.ico"});
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/**.html"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"))
                .requestMatchers(new AntPathRequestMatcher("/bootstrap/**"))
                .requestMatchers(new AntPathRequestMatcher("/static/fonts.icomoon/**"))
                .requestMatchers(new AntPathRequestMatcher("/demo-files/**"))
                .requestMatchers(new AntPathRequestMatcher("/fonts/**"))
                .requestMatchers(new AntPathRequestMatcher("/scss/**"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout() // logout설정
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index")
                .permitAll().and()
                .authorizeRequests() // 인가에 대한 설정
                .antMatchers("/main").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/users/join").permitAll()
                .antMatchers("/users/welcome").permitAll()
                .antMatchers(HttpMethod.GET,"/api/emailCheck").permitAll()
                .antMatchers(HttpMethod.POST,"/api/emailCheck").permitAll()
                .antMatchers(HttpMethod.POST,"/api/**").permitAll()
                .antMatchers("/api/emailCheck").permitAll()
//                .antMatchers("/admin/register").permitAll()
                .antMatchers("/users/delete").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/users/login").permitAll()
//                .antMatchers("/studyContent/images/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/studyContent/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/study/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/studyCurriculum/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/users/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/recruitStudy/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin() // 사용자가 정의하는 로그인 화면을 만들겠다.
                .loginProcessingUrl("/users/login") // 로그인 화면
                .loginPage("/users/login").permitAll() // 사용자가 입력한 id, password가 전달되는 url경로(필터가처리)
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/users/login?fail=true").and().csrf().ignoringAntMatchers("/**");
    }


}

//.and().csrf().ignoringAntMatchers("/**")