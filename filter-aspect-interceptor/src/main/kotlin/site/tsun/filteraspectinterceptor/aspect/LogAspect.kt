package site.tsun.filteraspectinterceptor.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class LogAspect {

    @Around("execution(* site.tsun.filteraspectinterceptor.controller.HelloController.*(..))")
    fun handleControllerMethod(pjp: ProceedingJoinPoint): Any {
        println("Log Aspect Start")
        val obj = pjp.proceed()
        println("Log Aspect End")
        return obj
    }
}