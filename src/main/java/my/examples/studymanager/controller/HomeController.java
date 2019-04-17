package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.security.StudyManagerSecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/index")
    public String index( ){

//        System.out.println("================"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            return "redirect:/study/list";
        }
        return "/index";
    }
}
