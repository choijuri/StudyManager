package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.domain.Study;
import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.service.CurriculumDetailService;
import my.examples.studymanager.service.CurriculumService;
import my.examples.studymanager.service.StudyContentService;
import my.examples.studymanager.service.StudyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/studyContent")
public class StudyContentController {
    private final StudyContentService studyContentService;
    private final StudyService studyService;
    private final CurriculumService curriculumService;
    private final CurriculumDetailService curriculumDetailService;

    @GetMapping("/{curriculumDetailId}")
    public String studyContent(@PathVariable(name = "curriculumDetailId") Long curriculumDetailId,Model model){

        StudyContent studyContent = studyContentService.getStudyContentByCurriculumDetailId(curriculumDetailId);
        if(studyContent == null){
            model.addAttribute("studyContent",new StudyContent());
        }else {
            model.addAttribute("studyContent", studyContent);
        }

        Curriculum curriculum = curriculumService.getCurriculumByCurriculumDetailId(curriculumDetailId);
        Study study = studyService.getStudyNameByCurriculumId(curriculum.getCurriculumId());

        model.addAttribute("curriculumContent", curriculum.getCurriculumContent());
        model.addAttribute("curriculumDetailContent",curriculumDetailService.getCurriculumDetail(curriculumDetailId).getCurriculumDetailContent());
        model.addAttribute("curriculumDetailId",curriculumDetailId);
        model.addAttribute("studyId",study.getStudyId());
        return "study/studyContent";
    }

    @PostMapping
    public String studyContent(
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


        Curriculum curriculum = curriculumService.getCurriculumByCurriculumDetailId(curriculumDetailId);
        Study study = studyService.getStudyNameByCurriculumId(curriculum.getCurriculumId());

        model.addAttribute("curriculumContent", curriculumContent);
        model.addAttribute("curriculumDetailContent",curriculumDetailContent);
        model.addAttribute("curriculumDetailId",curriculumDetailId);
        model.addAttribute("studyId",study.getStudyId());
        return "study/studyContent";
    }

    @GetMapping("/register")
    public String studyContentRegister(@RequestParam(name = "curriculumDetailId") Long curriculumDetailId, Model model){
        model.addAttribute("curriculumDetailId",curriculumDetailId);
        return "study/studyContentRegister";
    }
}
