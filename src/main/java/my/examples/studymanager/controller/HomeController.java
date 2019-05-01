package my.examples.studymanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/index")
    public String index( ){

        if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            return "redirect:/study/list";
        }
        return "/index";
    }
}
