package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Study;
import my.examples.studymanager.dto.StudyDto;
import my.examples.studymanager.dto.StudyFormDto;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.StudyService;
import my.examples.studymanager.service.StudyUserService;
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
@RequestMapping("/api/studies")
@RequiredArgsConstructor
public class StudyApiController {
    private final StudyService studyService;
    private final StudyUserService studyUserService;

    @PostMapping
    public ResponseEntity<StudyDto> addStudy(@Valid @RequestBody StudyFormDto studyFormDto, BindingResult bindingResult){
        System.out.println(studyFormDto.getCategoryId());

        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        Long studyId = studyService.addStudy(studyFormDto);
        StudyDto studyDto = new StudyDto();
        studyDto.setStudyId(studyId);
        studyDto.setStudyInformation(studyFormDto.getStudyInformation());
        studyDto.setStudyName(studyFormDto.getStudyName());
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        studyUserService.addStudyUser(studyId,securityUser.getId());
        return new ResponseEntity<>(studyDto, HttpStatus.CREATED);
    }
}
