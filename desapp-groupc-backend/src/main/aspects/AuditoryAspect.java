package main.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AuditoryAspect {
  /* Get actual class name to be printed on */
  static Logger log = Logger.getLogger(AuditoryAspect.class.getName());

  @Around("execution(* main.webservices..*(..))")
  public Object aroundAuditory(ProceedingJoinPoint pjp) throws Throwable {
    long startMillis = 0;
    Object ret = null;
    try {
      startMillis= System.currentTimeMillis();
      ret = pjp.proceed();
    } finally {
      long finishMillis= System.currentTimeMillis();
      log.info("Tiempo: " + String.valueOf(finishMillis - startMillis) + " ms");
    }
    return ret;
  }
}
