package co.appdev.boilerplate.mvpkotlin.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.appdev.boilerplate.mvpkotlin.R
import co.appdev.boilerplate.mvpkotlin.data.model.repository.user.User
import co.appdev.boilerplate.mvpkotlin.databinding.ItemRibotBinding
import java.util.*
import javax.inject.Inject

class UsersAdapter @Inject constructor() : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    private var mUsers: List<User>

    fun setRibots(users: List<User>) {
        mUsers = users
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val viewDataBinding: ItemRibotBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_ribot,
            parent,
            false
        )
        return UserViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = mUsers[position]
        holder.binding.textName.setText(String.format("%s", user.name))
        holder.binding.textAge.setText(user.age.toString())
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    inner class UserViewHolder(itemView: ItemRibotBinding) : RecyclerView.ViewHolder(itemView.getRoot()) {
        val binding: ItemRibotBinding

        init {
            binding = itemView
        }
    }

    init {
        mUsers = ArrayList<User>()
    }
}
