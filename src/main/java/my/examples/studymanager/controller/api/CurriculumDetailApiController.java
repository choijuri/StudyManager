package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.CurriculumDetail;
import my.examples.studymanager.domain.Study;
import my.examples.studymanager.dto.CurriculumDetailDto;
import my.examples.studymanager.dto.CurriculumDetailFormDto;
import my.examples.studymanager.dto.CurriculumDetailSendDto;
import my.examples.studymanager.service.CurriculumDetailService;
import my.examples.studymanager.service.StudyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/curriculumDetails")
@RequiredArgsConstructor
public class CurriculumDetailApiController {
    private final CurriculumDetailService curriculumDetailService;
    private final StudyService studyService;

    @GetMapping("/add")
    public String addCurriculumDetail(){
        return null;
    }

    //커리큘럼 디테일 등록하기
    @PostMapping("/add")
    public ResponseEntity<Long> addCurriculum(@Valid @RequestBody List<CurriculumDetailFormDto> curriculumDetailFormDtoList){
        Long curriculumId = curriculumDetailService.addCurriculumDetail(curriculumDetailFormDtoList);
        Long studyId = studyService.getStudyNameByCurriculumId(curriculumId).getStudyId();
        return new ResponseEntity<>(studyId, HttpStatus.CREATED);
    }

    // 커리큘럼을 클릭했을 때, 커리큘럼 디테일 내용 보내주기
    @PostMapping
    public ResponseEntity<List<CurriculumDetailSendDto>> getCurriculumDetails(@RequestBody CurriculumDetailDto curriculumDetailDTO){

        List<CurriculumDetail> list = curriculumDetailService.getCurriculumDetailByCurriculumId(curriculumDetailDTO.getCurriculumId());
        List<CurriculumDetailSendDto> data = new ArrayList<>();
        for (CurriculumDetail c : list){
            CurriculumDetailSendDto cf = new CurriculumDetailSendDto();
            cf.setCurriculumDetailContent(c.getCurriculumDetailContent());
            cf.setCurriculumDetailId(c.getCurriculumDetailId());
            data.add(cf);
        }

        return new ResponseEntity<List<CurriculumDetailSendDto>>(data, HttpStatus.OK);
    }
}
