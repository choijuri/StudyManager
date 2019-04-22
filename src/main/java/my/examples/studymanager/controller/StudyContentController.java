package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.service.StudyContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/studyContent")
public class StudyContentController {
    private final StudyContentService studyContentService;

    @GetMapping
    public String studyContent(@RequestParam(name = "curriculumDetailId") Long curriculumDetailId, Model model) {
        StudyContent studyContent = studyContentService.getStudyContentByCurriculumId(curriculumDetailId);

        model.addAttribute("studyContent", studyContent);
        return "study/studyContent";
    }
}
