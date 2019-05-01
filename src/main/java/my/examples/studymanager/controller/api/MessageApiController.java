package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.SendMessageDto;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.MessageService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    //메세지 알림 정보 가져오기
    @GetMapping
    public int getApiMessageCount(){
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return messageService.getNewMessageCount(securityUser.getId());
    }

}
