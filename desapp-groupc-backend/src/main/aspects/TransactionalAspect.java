package main.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.transaction.annotation.Transactional;

@Aspect
public class TransactionalAspect {

  @Around("execution(*org.springframework.transaction.annotation.Transactional)")
  public Object aroundTransactional(ProceedingJoinPoint pjp) {
    return null;
  }

}
