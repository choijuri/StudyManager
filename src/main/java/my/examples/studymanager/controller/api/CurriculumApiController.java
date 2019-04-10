package my.examples.studymanager.controller.api;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.service.CurriculumService;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONArray;

import java.util.ArrayList;
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

    @PostMapping
    public String addCurriculum(@RequestBody String paramData){
        List<CurriculumFormDto> curriculumFormDtoList = new ArrayList<>();

        JSONArray jsonArray =  JSONArray.fromObject(paramData);
        curriculumFormDtoList = jsonArray.subList(0, jsonArray.size());
        curriculumService.addCurriculum(curriculumFormDtoList);
        return "";
    }

}
