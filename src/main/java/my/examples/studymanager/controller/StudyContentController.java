package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.service.StudyContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/studyContent")
public class StudyContentController {
    private final StudyContentService studyContentService;

    @PostMapping
    public String studyContent(
//            @RequestBody StudyContentDto studyContentDto,
            @RequestParam(name = "curriculumDetailContent") String curriculumDetailContent,
                               @RequestParam(name = "curriculumContent") String curriculumContent,
                               @RequestParam(name = "curriculumDetailId") Long curriculumDetailId,
                               Model model ) {


        StudyContent studyContent = studyContentService.getStudyContentByCurriculumDetailId(curriculumDetailId);
        if(studyContent == null){
            model.addAttribute("studyContent",new StudyContent());
        }else {
            model.addAttribute("studyContent", studyContent);
        }
        model.addAttribute("curriculumContent", curriculumContent);
        model.addAttribute("curriculumDetailContent",curriculumDetailContent);
        model.addAttribute("curriculumDetailId",curriculumDetailId);

        return "study/studyContent";
    }

    @GetMapping("/register")
    public String studyContent(@RequestParam(name = "curriculumDetailId") Long curriculumDetailId, Model model){
        model.addAttribute("curriculumDetailId",curriculumDetailId);
        return "study/studyContentRegister";
    }
}
