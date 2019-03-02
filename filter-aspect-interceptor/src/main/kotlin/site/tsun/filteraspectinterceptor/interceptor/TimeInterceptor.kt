package site.tsun.filteraspectinterceptor.interceptor

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class TimeInterceptor : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        println("TimeInterceptor Pre Handle called")
        return super.preHandle(request, response, handler)
    }

    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        println("TimeInterceptor Post Handle called")
        super.postHandle(request, response, handler, modelAndView)
    }

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        println("TimeInterceptor After Completion called")
        super.afterCompletion(request, response, handler, ex)
    }
}