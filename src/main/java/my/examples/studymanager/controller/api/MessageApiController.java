package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.SendMessageDto;
import my.examples.studymanager.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageApiController {
    private final MessageService messageService;

    //메시지 보내기
    @PostMapping
    public SendMessageDto sendMessage(@Valid @RequestBody SendMessageDto sendMessageDto){
        messageService.addMessage(sendMessageDto);
        return sendMessageDto;
    }

    /*
        //커리큘럼 등록
    @PostMapping
    public List<CurriculumFormDto> addCurriculum(@Valid @RequestBody List<CurriculumFormDto> curriculumFormDtoList){
        curriculumService.addCurriculum(curriculumFormDtoList);
        return curriculumFormDtoList;
    }
     */
}
