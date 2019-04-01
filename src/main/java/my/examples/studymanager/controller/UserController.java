package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.User;
import my.examples.studymanager.dto.JoinDto;
import my.examples.studymanager.service.UserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/join")
    public String joinform(){
        return "users/joinform";
    }

    @PostMapping("/join")
    public String join(@Valid JoinDto joinDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        if(!joinDto.getPasswd1().equals(joinDto.getPasswd2())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않아요!!");
        }

        User user = new User();
        user.setName(joinDto.getName());
        user.setEmail(joinDto.getEmail());
        user.setPhone(joinDto.getPhone());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(joinDto.getPasswd1()));
        User result = userService.addUser(user);

        return "redirect:/index";
    }
}
