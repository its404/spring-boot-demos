package site.tsun.springsecurityjwt.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import site.tsun.springsecurityjwt.security.JwtTokenProvider
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import site.tsun.springsecurityjwt.dto.LoginDto
import site.tsun.springsecurityjwt.dto.LoginSuccessDto

@RestController
@RequestMapping("/auth")
class AuthController {
    @Autowired
    lateinit var authenticationManager: AuthenticationManager
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder
    @Autowired
    lateinit var tokenProvider: JwtTokenProvider

    @PostMapping("/login")
    fun authenticateUser(@Valid @RequestBody loginDto: LoginDto): ResponseEntity<Any> {

        val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        loginDto.username,
                        loginDto.password
                )
        )

        SecurityContextHolder.getContext().authentication = authentication

        val jwt = tokenProvider.generateToken(authentication)

        return ResponseEntity.ok(LoginSuccessDto(jwt))
    }
}