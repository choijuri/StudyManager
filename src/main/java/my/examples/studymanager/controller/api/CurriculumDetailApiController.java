package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.CurriculumDetailFormDto;
import my.examples.studymanager.service.CurriculumDetailService;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/curriculumDetail")
@RequiredArgsConstructor
public class CurriculumDetailApiController {
    private final CurriculumDetailService curriculumDetailService;

    @GetMapping
    public String addCurriculumDetail(){
        return null;
    }

    @PostMapping
    public String addCurriculumDetail(@RequestBody String paramData){
        List<CurriculumDetailFormDto> curriculumDetailFormDtoList = new ArrayList<>();
        curriculumDetailFormDtoList = JSONArray.fromObject(paramData);

        curriculumDetailService.addCurriculumDetail(curriculumDetailFormDtoList);
        return null;
    }
}
