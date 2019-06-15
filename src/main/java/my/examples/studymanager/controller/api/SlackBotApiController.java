package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/slackbot")
@RequiredArgsConstructor
public class SlackBotApiController {

    @GetMapping("/test")
    public void webHook() {

        SlackApi api = new SlackApi("https://hooks.slack.com/services/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");    //웹훅URL
        api.call(new SlackMessage("#general", "TEST-WEBHOOK", "연습~~~~"));

    }
}
