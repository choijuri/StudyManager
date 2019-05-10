package my.examples.studymanager.controller;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Message;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.MessageService;
import my.examples.studymanager.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;
    private final UserService userService;

    //유저에게 온 메시지 리스트
    @GetMapping("/list")
    public String getMessages(Model model){
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Message> messagesByUser = messageService.getMessagesByUser(securityUser.getId());
        model.addAttribute("messageList", messagesByUser);
        //return "redirect:history.go(-1)";
        return "message/messagelist";
    }

    //메시지 한건 보기 - 한건 불러오기, 조회수 +1
    @GetMapping("messagedetail/{messageId}")
    public String getMessage(@PathVariable(name= "messageId") Long messageId,
            Model model){
        model.addAttribute("message",messageService.getMessageByMessageId(messageId));
        messageService.updateReadCount(messageId);
        return "message/messagedetail";
    }
}
