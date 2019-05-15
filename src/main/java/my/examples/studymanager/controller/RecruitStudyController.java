package my.examples.studymanager.controller;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.service.CategoryService;
import my.examples.studymanager.service.RecruitStudyService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recruitstudy")
public class RecruitStudyController {
    private final RecruitStudyService recruitStudyService;
    private final CategoryService categoryService;


    //recruitStudy list 목록, 검색, 페이지
    @GetMapping("/list")
    public String recruitStudyList(
            @RequestParam(name = "page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "searchKind", required = false) String searchKind,
            @RequestParam(name = "categoryId", required = false) Long categoryId,
            @RequestParam(name = "searchStr",required = false) String searchStr,
            Model model
    ){
        model.addAttribute("isLogin",(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))? true : false);

        List<RecruitStudy> recruitStudyList = recruitStudyService.searchRecruitStudy(page, categoryId, searchKind, searchStr);
        model.addAttribute("recruitStudyList", recruitStudyList);
        model.addAttribute("categories", categoryService.getCategories());
        return "recruitstudy/recruitstudylist";
    }




    //recruitStudy 등록페이지
    @GetMapping("/recruitstudyregister")
    public String recruitStudyForm(Model model){
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("isLogin",(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))? true : false);
        return "recruitstudy/recruitstudyregister";
    }


//    //recruitStudy 등록
//    @PostMapping("/register")
//    public String recruitstudy(@Valid RecruitStudyDto recruitStudyDto, BindingResult bindingResult){
//
//        if(bindingResult.hasErrors()){
//            throw new IllegalArgumentException(bindingResult.toString());
//        }
//        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        recruitStudyService.addRecruitStudy(recruitStudyDto, securityUser.getId());
//        return "recruitstudy/recruitstudydetail";
//    }


    //recruitStudyDetail 페이지 모집스터디 한건 보기
    @GetMapping("/recruitstudydetail/{recruitId}")
    public String getRecruitStudy(@PathVariable(name = "recruitId") Long recruitId,
                           Model model){
        model.addAttribute("recruitstudy", recruitStudyService.getRecruitStudy(recruitId));
        model.addAttribute("isLogin",(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))? true : false);
        return "recruitstudy/recruitstudydetail";
    }

}
