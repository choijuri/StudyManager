package my.examples.studymanager.controller;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {
    private final StudyService studyService;
    private final StudyUserService studyUserService;
    private final CurriculumService curriculumService;
    private final CategoryService categoryService;

    //내 스터디 보기
    @GetMapping("/list")
    public String getStudies(Model model){
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("isLogin",(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))? true : false);
        model.addAttribute("studyList",studyService.getStudiesByUser(securityUser.getId()));
        model.addAttribute("categories",categoryService.getCategories());
        return "study/main_";
    }

    @GetMapping("/list/{categoryId}")
    public String getStudiesByCategoryId(@PathVariable Long categoryId, Model model){
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("isLogin",(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))? true : false);
        model.addAttribute("studyList",studyService.getStudiesByUserIdAndCategoryId(securityUser.getId(),categoryId));
        model.addAttribute("categories",categoryService.getCategories());
        return "study/main_";
    }

    //스터디 한건 보기
    @GetMapping("/{studyId}")
    public String getStudy(@PathVariable(name = "studyId") Long studyId,
                          Model model){
        model.addAttribute("study", studyService.getStudy(studyId));
        return "study/";
    }

    //스터디등록하는 페이지로 가기
    @GetMapping("/add")
    public String studyadd(Model model){
        model.addAttribute("categories",categoryService.getCategories());
        return "study/studyregister";
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

    @GetMapping("/studyDetail/{studyId}")
    public String studyDetail(@PathVariable(name = "studyId") Long studyId,
                              Model model){

        model.addAttribute("study",studyService.getStudy(studyId));
        model.addAttribute("curriculums",curriculumService.getCurriculumByStudyId(studyId));
        return "study/studyDetail";
    }
}
