package com.dani.user_management


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
//import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*


class UserListAdapter(
    private val context: Context
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    lateinit var userList : ArrayList<User>
    val TAG = UserListAdapter::class.java.name
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = userList[position]
        holder.setData(user.uName, user.email,position)
    }

    fun setUsers(users: ArrayList<User>) {
        userList = users
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView) {
        var pos = 0
        fun setData(uName: String, email: String,pos: Int) {
            itemView.UserName.text = uName
            itemView.Email_Text.text = email
            this.pos = pos
        }
    }
}
