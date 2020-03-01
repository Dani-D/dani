package com.dani.user_management

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUser : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        databaseHelper = DatabaseHelper(this)

        reg.setOnClickListener{
            var isValid = true
            var genId = rg.checkedRadioButtonId
            if(first_name.text.toString().isEmpty()){
                isValid = false
            }
            else if(last_name.text.toString().isEmpty()){
                isValid = false
            }
            else if(user_name.text.toString().isEmpty()){
                isValid = false
            }
            else if(email.text.toString().isEmpty()){
                isValid = false
            }
            else if(phone_no.text.toString().isEmpty()){
                isValid = false
            }
            else if(password.text.toString().isEmpty()){
                isValid = false
            }
            else if(genId==-1){
                isValid=false
            }
            else
                isValid=true


            if(isValid){
                val db = databaseHelper.writableDatabase
                val cv = ContentValues()
                cv.put(UMContract.UserEntry.COLUMN_FIRST_NAME, first_name.text.toString())
                cv.put(UMContract.UserEntry.COLUMN_LAST_NAME, last_name.text.toString())
                cv.put(UMContract.UserEntry.COLUMN_USER_NAME, user_name.text.toString())
                cv.put(UMContract.UserEntry.COLUMN_EMAIL, email.text.toString())
                cv.put(UMContract.UserEntry.COLUMN_PHONE_NO, phone_no.text.toString())
                var genId = rg.checkedRadioButtonId
                var ge : RadioButton= findViewById(genId)
                var gender = ge.text.toString()
                cv.put(UMContract.UserEntry.COLUMN_GENDER, gender)
                cv.put(UMContract.UserEntry.COLUMN_PASSWORD, password.text.toString())
                var result = db.insert(UMContract.UserEntry.TABLE_NAME,null,cv)
                setResult(Activity.RESULT_OK, Intent())
                Toast.makeText(applicationContext,"Registered successfully",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext,"Fill all inputs and try again",Toast.LENGTH_LONG).show()
            }
            finish()
        }
    }
}
