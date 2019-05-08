package my.examples.studymanager.controller.api;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.service.CurriculumService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/curriculum")
@RequiredArgsConstructor
public class CurriculumApiController {
    private final CurriculumService curriculumService;

    @GetMapping
    public String getCurriculums(@RequestParam(name = "studyId") Long studyId){
        curriculumService.getCurriculumByStudyId(studyId);
        return "";
    }

    //커리큘럼 등록
    @PostMapping
    public List<CurriculumFormDto> addCurriculum(@Valid @RequestBody List<CurriculumFormDto> curriculumFormDtoList){

        curriculumService.addCurriculum(curriculumFormDtoList);
        return curriculumFormDtoList;
    }

}
