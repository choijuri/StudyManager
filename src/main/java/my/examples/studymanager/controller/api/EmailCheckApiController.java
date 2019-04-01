package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emailchk")
@RequiredArgsConstructor
public class EmailCheckApiController {
    private final UserService userService;

    @GetMapping
    public int getEmails(@RequestParam(name = "email") String email){
        int result = userService.emailChk(email);
        return result;
    }
}
