package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.EmailCheckDto;
import my.examples.studymanager.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/emailCheck")
@RequiredArgsConstructor
public class EmailCheckApiController {
    private final UserService userService;

    @PostMapping
    public int emailCheck(@RequestParam(name = "email") String email){
        int emailChk = userService.emailChk(email);
        return emailChk;
    }
}
