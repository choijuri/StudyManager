package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import my.examples.studymanager.domain.User;
import my.examples.studymanager.dto.JoinFormDto;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/join")
    public String joinform(JoinFormDto joinFormDto, ModelMap modelMap){
        modelMap.addAttribute("joinDto", joinFormDto);
        return "users/joinform";
    }

    @PutMapping("/join")
    public String join(@RequestBody @Valid JoinFormDto joinFormDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        if(!joinFormDto.getPasswd1().equals(joinFormDto.getPasswd2())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않아요!!");
        }

        User user = new User();
        user.setName(joinFormDto.getName());
        user.setEmail(joinFormDto.getEmail());
        user.setPhone(joinFormDto.getPhone());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(joinFormDto.getPasswd1()));
        User result = userService.addUser(user);

        return "/index";
//        return null;
    }

    @GetMapping("/login")
    public String loginform(@RequestParam(name = "fail",
            required = false,
            defaultValue = "false") String errorFlag) {
        return "users/loginform";
    }

    @PostMapping("/login")
    public String login(){

        return"/index";
    }

//    @GetMapping("/logout")
//    public String logout(){
//        return "/index";
//    }
//
//    @GetMapping("/mypage")
//    public String mypage(){
//        return "users/mypage";
//    }
//
//    @PutMapping("/changePwd")
//    public String changePwd(@RequestParam(name = "changePwd") String changePwd){
//
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        String chagePasswd = passwordEncoder.encode(changePwd);
//
//        StudyManagerSecurityUser studyManagerSecurityUser = (StudyManagerSecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        userService.modifyPasswd(chagePasswd, studyManagerSecurityUser.getId());
//        return "users/mypage";
//    }
}
