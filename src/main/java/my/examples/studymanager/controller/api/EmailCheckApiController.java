package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emailCheck")
@RequiredArgsConstructor
public class EmailCheckApiController {
    private final UserService userService;

    @PostMapping
    public int getEmails(@RequestBody Map<Object,Object> email){
        System.out.println(email.get("email"));
        int result = userService.emailChk(email.get("email").toString());
        return result;
    }
}
