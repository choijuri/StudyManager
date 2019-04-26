package my.examples.studymanager.controller;


import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Message;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import my.examples.studymanager.service.MessageService;
import my.examples.studymanager.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;
    private final UserService userService;

    @GetMapping("/send")
    public String sendMessage(Model model){
        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Message> messagesByUser = messageService.getMessagesByUser(securityUser.getId());
        model.addAttribute("messages", messagesByUser);
        return "history.go(-1)";
    }

    @GetMapping("/receivemessageform")
    public String receivemessageform(){
        return "message/receiveform";
    }

//    @PostMapping("/receive")
//    public String receivemessage(
//            @RequestParam(name = "messagecontent") String messagecontent,
//            @RequestParam(name = "user") String userEmail){
//        StudyManagerSecurityUser securityUser = (StudyManagerSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        messageService.addMessage(securityUser.getId(),messagecontent,userService.getUserIdByEmail(userEmail));
//        return "message/receive";
//    }
}
