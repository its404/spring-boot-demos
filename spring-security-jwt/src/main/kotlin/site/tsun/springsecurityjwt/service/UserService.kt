package site.tsun.springsecurityjwt.service

import org.springframework.stereotype.Service
import site.tsun.springsecurityjwt.model.User

@Service
interface UserService {
    fun findById(id: Long): User
    fun save(record: User): Int
    fun update(record: User): Int
    fun delete(id: Long): Boolean
    fun findByUsernameOrEmail(usernameOrEmail: String): User?
}