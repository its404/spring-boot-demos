package site.tsun.springsecurityjwt

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("site.tsun.springsecurityjwt.mapper")
class SpringSecurityJwtApplication

fun main(args: Array<String>) {
	runApplication<SpringSecurityJwtApplication>(*args)
}
