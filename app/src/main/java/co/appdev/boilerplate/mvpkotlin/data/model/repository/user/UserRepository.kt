package co.appdev.boilerplate.mvpkotlin.data.model.repository.user


class UserRepository(var userDao: UserDao?) : UserRepo {

    override val isUserRepoEmpty: Boolean get() = userDao!!.loadAll()!!.isEmpty()

    override fun insertUsers(userList: List<User?>?) {
        userDao!!.insertAll(userList)
    }

    override fun loadUsers(): List<User?>? {
        return userDao!!.loadAll()
    }

}
