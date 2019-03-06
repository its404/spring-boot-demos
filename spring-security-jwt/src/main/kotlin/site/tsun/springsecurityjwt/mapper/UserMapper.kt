package site.tsun.springsecurityjwt.mapper

import org.apache.ibatis.annotations.*
import site.tsun.springsecurityjwt.model.User

interface UserMapper {
    @Delete("delete from user where id=#{id}")
    fun delete(id: Long): Boolean

    @Insert("insert into user(name, email) values(#{name}, #{email})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    fun save(record: User): Int

    @Select("select * from user where id=#{id}")
    fun findById(id: Long): User

    @Update("update user set name=#{name}, email=#{email} where id=#{id}")
    fun update(record: User): Int

    @Select("select * from user where username=#{username}")
    fun findByUsername(username: String): User?

    @Select("select * from user where email=#{email}")
    fun findByEmail(email: String): User?
}