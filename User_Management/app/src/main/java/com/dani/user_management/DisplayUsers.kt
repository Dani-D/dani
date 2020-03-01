package com.dani.user_management

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_display_users.*
import kotlinx.android.synthetic.main.list_item.*

class Display_Users : AppCompatActivity() {

    private val sharedPrefFile = "SP_INFO"
    private val userListAdapter = UserListAdapter(this)
    lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_users)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        databaseHelper = DatabaseHelper(this)
        recyclerView.adapter = userListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        userListAdapter.setUsers(DataManager.fetchAllUsers(databaseHelper))

        logout_button.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            editor.commit()
            var intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
