package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.dto.EmailCheckDto;
import my.examples.studymanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users/emailCheck")
@RequiredArgsConstructor
public class EmailCheckApiController {
    private final UserService userService;

    @PostMapping("//")
    public ResponseEntity<Integer> emailCheck(@RequestBody EmailCheckDto emailCheckDto){
        int emailChk = userService.emailChk(emailCheckDto.getEmail());
        return new ResponseEntity<>(emailChk, HttpStatus.OK);
    }

}
