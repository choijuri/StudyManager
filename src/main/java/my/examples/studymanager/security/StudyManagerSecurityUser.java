package my.examples.studymanager.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class StudyManagerSecurityUser extends User {
    private Long id;
    private String name;

    public StudyManagerSecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username, password, true, true, true, true, authorities);
    }

    public String getEmail(){
        return super.getUsername();
    }
}
