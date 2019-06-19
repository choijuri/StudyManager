package my.examples.studymanager.aop;

import lombok.extern.slf4j.Slf4j;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

    Logger logger =  LoggerFactory.getLogger(LoggerAspect.class);

    //apicontroller 모든 메서드
    @Around("execution(* my.examples.studymanager.controller.api.*.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        return result;
    }

    @AfterThrowing(value = "execution(* my.examples.studymanager.controller.*.*(..))", throwing = "exception")
    public void writeFailLog(JoinPoint joinPoint, Exception exception) throws Throwable {
        //logging
        //exception 으로 해당 메서드에서 발생한 예외를 가져올 수 있다.
        logger.error("Exception occurred : {} ", exception);
        SlackApi api = new SlackApi("https://hooks.slack.com/services/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");    //웹훅URL
        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setChannel("#general");
        slackMessage.setUsername("study manager");
        slackMessage.setText("error message = "+ exception);
        api.call(slackMessage);
    }
}


