package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.dto.StudyContentDto;
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
    public String studyContent(@RequestBody StudyContentDto studyContentDto, Model model ) {
        StudyContent studyContent = studyContentService.getStudyContentByCurriculumId(studyContentDto.getCurriculumDetailId());
        model.addAttribute("studyContent", studyContent);
        model.addAttribute("curriculumContent", studyContentDto.getCurriculumContent());
        model.addAttribute("curriculumDetailContent",studyContentDto.getCurriculumDetailContent());

        return "study/studyContent";
    }
}
