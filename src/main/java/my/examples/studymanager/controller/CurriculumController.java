package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Study;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.dto.StudyDto;
import my.examples.studymanager.dto.StudyFormDto;
import my.examples.studymanager.service.CurriculumService;
import my.examples.studymanager.service.StudyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/curriculum")
public class CurriculumController {

    private final CurriculumService curriculumService;
    private final StudyService studyService;

    //스터디 커리큘럼 등록페이지
    @GetMapping("/curriculumregister")
    public String curriculumregister(@RequestParam("studyId") Long studyId, Model model){
        model.addAttribute("study",studyService.getStudy(studyId));
        return "curriculum/curriculumregister";
    }

    //디테일 커리큘럼 등록페이지
    @GetMapping("/curriculumdetailregister")
    public String curriculumdetailregister(){
        return "curriculum/curriculumdetailregister";
    }
}
