package site.tsun.springsecurityjwt.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import site.tsun.springsecurityjwt.mapper.UserMapper
import site.tsun.springsecurityjwt.model.User
import site.tsun.springsecurityjwt.service.UserService

@Service
class UserServiceImpl: UserService {

    @Autowired
    lateinit var userMapper: UserMapper

    override fun findById(id: Long): User {
        return userMapper.findById(id)
    }

    @Transactional(propagation= Propagation.REQUIRED)
    override fun save(record: User): Int {
        return userMapper.save(record)
    }

    @Transactional(propagation=Propagation.REQUIRED)
    override fun update(record: User): Int {
        return userMapper.update(record)
    }

    @Transactional(propagation=Propagation.REQUIRED)
    override fun delete(id: Long): Boolean {
        return userMapper.delete(id)
    }

    override fun findByUsernameOrEmail(usernameOrEmail: String): User? {
        when (usernameOrEmail.contains("@")) {
            true -> return userMapper.findByEmail(usernameOrEmail)
            false ->return userMapper.findByUsername(usernameOrEmail)
        }
    }
}