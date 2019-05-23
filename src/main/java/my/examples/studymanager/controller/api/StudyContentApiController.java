package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.domain.Study;
import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.dto.StudyContentDto;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.CurriculumService;
import my.examples.studymanager.service.StudyContentService;
import my.examples.studymanager.service.StudyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studyContents")
@RequiredArgsConstructor
public class StudyContentApiController {
    private final StudyContentService studyContentService;
    private final StudyService studyService;
    private final CurriculumService curriculumService;

    @PostMapping
    public ResponseEntity<Long> studyContent(@RequestBody StudyContentDto studyContentDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = studyContentService.addStudyContent(studyContentDto,securityUser.getId());
        Curriculum curriculum = curriculumService.getCurriculumByCurriculumDetailId(studyContentDto.getCurriculumDetailId());
        Study study = studyService.getStudyNameByCurriculumId(curriculum.getCurriculumId());
        return new ResponseEntity<>(studyContentDto.getCurriculumDetailId(),HttpStatus.CREATED);
    }


//    @PostMapping
//    public String studyContent(@RequestBody StudyContentDto studyContentDto, Model model){
//        StudyContent studyContent = studyContentService.getStudyContentByCurriculumDetailId(studyContentDto.getCurriculumDetailId());
//        model.addAttribute("studyContent",studyContent);
//        model.addAttribute("curriculumContent", studyContentDto.getCurriculumContent());
//        model.addAttribute("curriculumDetailContent",studyContentDto.getCurriculumDetailContent());
//        return "redirect:/studyContent";
//    }

}
