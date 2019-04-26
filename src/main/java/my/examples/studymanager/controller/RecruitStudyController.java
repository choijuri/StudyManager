package my.examples.studymanager.controller;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.dto.RecruitStudyDto;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.CategoryService;
import my.examples.studymanager.service.RecruitStudyService;
import my.examples.studymanager.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recruitstudy")
public class RecruitStudyController {
    private final RecruitStudyService recruitStudyService;
    private final UserService userService;
    private final CategoryService categoryService;

    //recruitStudy 목록
    @GetMapping("/list")
    public String recruit(Model model){
        List<RecruitStudy> recruitStudyAll =
                recruitStudyService.getRecruitStudyAll();
        model.addAttribute("recruitStudy", recruitStudyAll);
        return "recruitstudy/recruit";
    }

    //recruitStudy 등록페이지
    @GetMapping("/recruitstudyregister")
    public String recruitStudyForm(Model model){
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("isLogin",(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))? true : false);
        return "recruitstudy/recruitstudyregister";
    }


    //recruitStudy 등록
    @PostMapping("/register")
    public String recruitstudy(@Valid RecruitStudyDto recruitStudyDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recruitStudyService.addRecruitStudy(recruitStudyDto, securityUser.getId());
        return "recruitstudy/list";
    }

}
