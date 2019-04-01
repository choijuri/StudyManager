package my.examples.studymanager.security;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.User;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor // final 인 필드만 초기화하는 생성자가 자동으로 만들어진다. 생성자주입시 사용
public class StudyManagerUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);

        if (user == null){
            throw new UsernameNotFoundException(email + "에 해당하는 사용자가 없습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE" + "ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE" + "USER"));

        StudyManagerSecurityUser studyManagerSecurityUser =  new StudyManagerSecurityUser(email, user.getPasswd(), authorities);
        studyManagerSecurityUser.setName(user.getName());

        return studyManagerSecurityUser;
    }
}
