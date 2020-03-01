package com.dani.user_management




import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val sharedPrefFile = "SP_INFO"
    lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper = DatabaseHelper(this)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        val sharedIdValue = sharedPreferences.getString("Username","")

        if(!sharedIdValue.equals("")){
            var intent = Intent(applicationContext,Display_Users::class.java)
            startActivity(intent)
        }





        register_button.setOnClickListener {
            var registerIntent = Intent(applicationContext,AddUser::class.java)
            startActivity(registerIntent)
        }


        login_button.setOnClickListener {
            var li = DataManager.fetchAllUsers(databaseHelper);
            var USERNAME= login_userName.getText().toString()
            var PASSWORD = login_password.getText().toString()
            var i = 0
            while (i <= li.lastIndex){
                var v = li.get(i)
                var RealUserName = v.uName
                var RealPassword = v.password
                if(USERNAME == RealUserName){
                    if (PASSWORD == RealPassword){
                        val editor:SharedPreferences.Editor =  sharedPreferences.edit()
                        editor.putString("Username",USERNAME)
                        editor.putString("Password",PASSWORD)
                        editor.apply()
                        editor.commit()
                        var intent = Intent(applicationContext,Display_Users::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(applicationContext,"Password is incorrect",Toast.LENGTH_SHORT).show()
                    }
                }
                i++
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
