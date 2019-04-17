package my.examples.studymanager.controller;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.StudyFormDto;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.StudyService;
import my.examples.studymanager.service.StudyUserService;
import my.examples.studymanager.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {
    private final StudyService studyService;
    private final StudyUserService studyUserService;
    private final UserService userService;

    //내 스터디 보기
    @GetMapping("/list")
    public String getStudies(Model model){
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("isLogin",(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))? true : false);
        model.addAttribute("studyList",studyService.getStudiesByUser(securityUser.getId()));
        return "/study/main";
    }

    //스터디 한건 보기
    @GetMapping("/{studyId}")
    public String getStudy(@PathVariable(name = "studyId") Long studyId,
                          Model model){
        model.addAttribute("study", studyService.getStudy(studyId));
        return "/study/";
    }

    //스터디 등록하기, 스터디유저 추가
    @PostMapping("/add")
    public String addStudy(@RequestBody @Valid StudyFormDto studyFormDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        Long studyId = studyService.addStudy(studyFormDto);

        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        studyUserService.addStudyUser(studyId,securityUser.getId());

        return "/study/";
    }

    @GetMapping("/addcode")
    public String addcode(){
        return "study/addcode";
    }

    @PostMapping("/addByCode")
    public String addByCode(String code){
        Long studyId = studyService.getStudyByCode(code);

        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        studyUserService.addStudyUserByCode(studyId,securityUser.getId());

        return "redirect:/study/list";
    }
}
