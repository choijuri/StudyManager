package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.RecruitStudyDto;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.RecruitStudyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity addRecruitStudy(@Valid @RequestBody RecruitStudyDto recruitStudyDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recruitStudyService.addRecruitStudy(recruitStudyDto, securityUser.getId());

        return new ResponseEntity(HttpStatus.CREATED);
    }



//    //recruitStudy 등록
//        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        recruitStudyService.addRecruitStudy(recruitStudyDto, securityUser.getId());
//        return "recruitstudy/recruitstudydetail";
//    }

//    private String recruitName;
//    private String sido1;
//    private String gugun1;
//    private int recruitNumber;
//    private String recruitContent;
//    private Long categoryId;
}
