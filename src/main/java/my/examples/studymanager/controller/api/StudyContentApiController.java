package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.dto.StudyContentDto;
import my.examples.studymanager.service.StudyContentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studyContent")
@RequiredArgsConstructor
public class StudyContentApiController {
    private final StudyContentService studyContentService;

    @PostMapping
    public String studyContent(@RequestBody StudyContentDto studyContentDto, Model model){
        StudyContent studyContent = studyContentService.getStudyContentByCurriculumDetailId(studyContentDto.getCurriculumDetailId());
        model.addAttribute("studyContent",studyContent);
        model.addAttribute("curriculumContent", studyContentDto.getCurriculumContent());
        model.addAttribute("curriculumDetailContent",studyContentDto.getCurriculumDetailContent());
        return "redirect:/studyContent";
    }
}
