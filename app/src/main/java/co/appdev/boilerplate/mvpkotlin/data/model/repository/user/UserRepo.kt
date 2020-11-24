package co.appdev.boilerplate.mvpkotlin.data.model.repository.user

interface UserRepo {
    val isUserRepoEmpty: Boolean
    fun insertUsers(userList: List<User?>?)
    fun loadUsers(): List<User?>?
}
