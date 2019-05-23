package my.examples.studymanager.controller.api;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.service.CurriculumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/curriculums")
@RequiredArgsConstructor
public class CurriculumApiController {
    private final CurriculumService curriculumService;


    //커리큘럼 등록
    @PostMapping
    public ResponseEntity<Long> addCurriculum(
            @Valid @RequestBody List<CurriculumFormDto> curriculumFormDtoList){
        curriculumService.addCurriculum(curriculumFormDtoList);
        Long studyId = curriculumFormDtoList.get(0).getStudyId();
        return new ResponseEntity<>(studyId, HttpStatus.CREATED);
    }

}
