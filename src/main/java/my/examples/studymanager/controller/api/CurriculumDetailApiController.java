package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.CurriculumDetail;
import my.examples.studymanager.dto.CurriculumDetailDTO;
import my.examples.studymanager.dto.CurriculumDetailFormDto;
import my.examples.studymanager.dto.CurriculumDetailSendDTO;
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

    @GetMapping("/add")
    public String addCurriculumDetail(){
        return null;
    }

    @PostMapping("/add")
    public String addCurriculumDetail(@RequestBody String paramData){
        List<CurriculumDetailFormDto> curriculumDetailFormDtoList = new ArrayList<>();
        curriculumDetailFormDtoList = JSONArray.fromObject(paramData);

        curriculumDetailService.addCurriculumDetail(curriculumDetailFormDtoList);
        return "/index";
    }

    @PostMapping
    public List<CurriculumDetailSendDTO> getCurriculumDetails(@RequestBody CurriculumDetailDTO curriculumDetailDTO){
        System.out.println(curriculumDetailDTO.getCurriculumId());
        List<CurriculumDetail> list = curriculumDetailService.getCurriculumDetailByCurriculumId(curriculumDetailDTO.getCurriculumId());
        List<CurriculumDetailSendDTO> data = new ArrayList<>();
        for (CurriculumDetail c : list){
            CurriculumDetailSendDTO cf = new CurriculumDetailSendDTO();
            cf.setCurriculumDetailContent(c.getCurriculumDetailContent());
            cf.setCurriculumDetailId(c.getCurriculumDetailId());
            data.add(cf);
        }

        return data;
    }
}
