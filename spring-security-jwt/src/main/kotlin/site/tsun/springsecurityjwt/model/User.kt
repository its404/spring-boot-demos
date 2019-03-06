package site.tsun.springsecurityjwt.model


data class User (val id: Int, val name: String, val username: String, val email: String, val password: String, var token: String?, var roles: HashSet<Role>) {
    constructor(id: Int, name: String, username: String, email: String, password: String) : this(id, name, username, email, password, null, HashSet())
}