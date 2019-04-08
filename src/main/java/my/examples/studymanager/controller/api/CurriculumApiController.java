package my.examples.studymanager.controller.api;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.repository.CurriculumRepository;
import my.examples.studymanager.service.CurriculumService;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/curriculum")
@RequiredArgsConstructor
public class CurriculumApiController {
    private final CurriculumService curriculumService;

    @GetMapping
    public List<Curriculum> getCurriculums(@RequestParam(name = "studyId") Long studyId){
        return curriculumService.getCurriculumByStudyId(studyId);
    }

    @PostMapping
    public List<String> addCurriculum(@RequestBody String paramData){
        List<CurriculumFormDto> curriculumFormDtoList = new ArrayList<>();

        JSONArray jsonArray =  JSONArray.fromObject(paramData);
        curriculumFormDtoList = jsonArray.subList(0, jsonArray.size());
        curriculumService.addCurriculum(curriculumFormDtoList);
        return null;
    }

}
