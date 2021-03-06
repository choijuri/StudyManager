package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.RecruitStudyDto;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.RecruitStudyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/recruitstudies")
@RequiredArgsConstructor
public class RecruitStudyApiController {
    private final RecruitStudyService recruitStudyService;

    //recruitStudy 등록
    @PostMapping
    public ResponseEntity addRecruitStudy(@Valid @RequestBody RecruitStudyDto recruitStudyDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recruitStudyService.addRecruitStudy(recruitStudyDto, securityUser.getId());

        return new ResponseEntity(HttpStatus.CREATED);
    }

}
