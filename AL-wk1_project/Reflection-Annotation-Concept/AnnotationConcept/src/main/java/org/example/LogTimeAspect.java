package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogTimeAspect{
    @Around("@annotation(LogExecutionTime)")
    public Object logTimeExecution(ProceedingJoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        }catch(Throwable e){
            throw new RuntimeException(e);
        }finally{
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) / 1000 + " second(s)");
        }
    }
}
