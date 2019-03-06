package site.tsun.springsecurityjwt.security

import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import site.tsun.springsecurityjwt.service.impl.UserServiceImpl


@Service
class CustomUserDetailsService : UserDetailsService {

    @Autowired
    lateinit var userService: UserServiceImpl

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(usernameOrEmail: String): UserDetails {
        // Let people login with either username or email
        val user = userService.findByUsernameOrEmail(usernameOrEmail)
        if (user == null) {
            throw UsernameNotFoundException("User not found with username or email : $usernameOrEmail")
        }

        return CustomUserDetails.create(user)
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    fun loadUserById(id: Long): UserDetails {
        val user = userService.findById(id)

        return CustomUserDetails.create(user)
    }
}