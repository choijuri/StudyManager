package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emailCheck")
@RequiredArgsConstructor
public class EmailCheckApiController {
    private final UserService userService;

    @PostMapping
    public int getEmails(@RequestParam(name="email") String email){
        int result = userService.emailChk(email);
        return result;
    }
}
