package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.service.CurriculumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/curriculum")
public class CurriculumController {

    private final CurriculumService curriculumService;

    //스터디 커리큘럼 등록페이지
    @GetMapping("/curriculumregister")
    public String curriculumregister(){
        return "curriculum/curriculumregister";
    }

    //커리큘럼 등록하기
    @PostMapping("/curriculumregister")
    public String addcurriculum(@Valid CurriculumFormDto curriculumFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        List<CurriculumFormDto> curriculumFormDtoList= new ArrayList<>();
        curriculumFormDtoList.add(curriculumFormDto);

        curriculumService.addCurriculum(curriculumFormDtoList);



        return "curriculum/adddetail";
    }
}
