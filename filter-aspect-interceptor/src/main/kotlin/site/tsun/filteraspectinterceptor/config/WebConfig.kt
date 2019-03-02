package site.tsun.filteraspectinterceptor.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import site.tsun.filteraspectinterceptor.filter.TimeFilter
import site.tsun.filteraspectinterceptor.interceptor.TimeInterceptor

@Configuration
class WebConfig : WebMvcConfigurer {

    @Autowired
    lateinit var timeInterceptor: TimeInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(timeInterceptor)
        super.addInterceptors(registry)
    }

    @Bean
    fun timeFilter(): FilterRegistrationBean<TimeFilter> {
        val registrationBean = FilterRegistrationBean<TimeFilter> ()

        val timeFilter = TimeFilter()
        registrationBean.filter = timeFilter
        val urls: ArrayList<String> = ArrayList()
        urls.add("/*")
        registrationBean.urlPatterns = urls
        return registrationBean
    }
}