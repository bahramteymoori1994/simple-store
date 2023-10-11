package com.example.store.store.logging.aspect;

import com.example.store.store.controllers.AbstractBaseController;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class AspectLogging
{
    protected Logger LOGGER = LoggerFactory.getLogger(AbstractBaseController.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Around("within(com.example.store.store.controllers.AbstractBaseController+)")
    public Object logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Signature signature = proceedingJoinPoint.getSignature();
        LogModel logModel = new LogModel();

        logModel.setMethodName(signature.getName());

        LOGGER.info("METHOD CALLED : " + signature.getName());

        String args = Arrays.stream(proceedingJoinPoint.getArgs())
                .map(i -> {
                    try {
                        return objectMapper.writeValueAsString(i);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining("\n"));

        logModel.setRequest(proceedingJoinPoint.getArgs());

        Object value;

        try {
            value = proceedingJoinPoint.proceed();

            if (value != null) {
                logModel.setResponse(value);
            }

            LOGGER.info("Success req/resp is " + objectMapper.writeValueAsString(logModel));
        } catch (Throwable e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);

            e.printStackTrace(printWriter);

            stringWriter.close();
            printWriter.close();

            logModel.setErrorTrace(stringWriter.toString());

            LOGGER.info("Failure req/resp is " + objectMapper.writeValueAsString(logModel));
            throw e;
        }
        return value;
    }
}

@Setter
@Getter
class LogModel
{
    private String methodName;
    private Object request;
    private Object response;
    private String errorTrace;
}