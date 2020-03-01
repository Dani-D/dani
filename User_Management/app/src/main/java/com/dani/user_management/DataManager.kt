package com.dani.user_management
import com.dani.user_management.UMContract
object DataManager {
    fun fetchUser(databaseHelper: DatabaseHelper, userId : String) : User ?{
        val db = databaseHelper.readableDatabase
        var user : User ?= null
        var columns = arrayOf(
            UMContract.UserEntry.COLUMN_FIRST_NAME,
            UMContract.UserEntry.COLUMN_LAST_NAME,
            UMContract.UserEntry.COLUMN_USER_NAME,
            UMContract.UserEntry.COLUMN_EMAIL,
            UMContract.UserEntry.COLUMN_PHONE_NO,
            UMContract.UserEntry.COLUMN_GENDER,
            UMContract.UserEntry.COLUMN_PASSWORD

        )

        val selection = UMContract.UserEntry.COLUMN_ID+" LIKE ?"
        val selectionArgs = arrayOf(userId)
        val cursor = db.query(
            UMContract.UserEntry.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null

        )

        val idPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_ID)
        val fnamePos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_FIRST_NAME)
        val lnamePos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_LAST_NAME)
        val unamePos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_USER_NAME)
        val emailPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_EMAIL)
        val phoPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_PHONE_NO)
        val genPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_GENDER)
        val pasPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_PASSWORD)

        while (cursor.moveToNext()){
            val id = cursor.getString(idPos)
            val fName = cursor.getString(fnamePos)
            val lName = cursor.getString(lnamePos)
            val uName = cursor.getString(unamePos)
            val ema = cursor.getString(emailPos)
            val phone = cursor.getString(phoPos)
            val gen = cursor.getString(genPos)
            val pass = cursor.getString(pasPos)
            user = User(id,fName,lName,uName,ema,phone,gen,pass)
        }
        cursor.close()
        return user
    }

    fun fetchAllUsers(databaseHelper: DatabaseHelper) : ArrayList<User>{
        val users = ArrayList<User>()
        val db = databaseHelper.readableDatabase
        val columns = arrayOf(
            UMContract.UserEntry.COLUMN_ID,
            UMContract.UserEntry.COLUMN_FIRST_NAME,
            UMContract.UserEntry.COLUMN_LAST_NAME,
            UMContract.UserEntry.COLUMN_USER_NAME,
            UMContract.UserEntry.COLUMN_EMAIL,
            UMContract.UserEntry.COLUMN_PHONE_NO,
            UMContract.UserEntry.COLUMN_GENDER,
            UMContract.UserEntry.COLUMN_PASSWORD
        )
        val cursor = db.query(
            UMContract.UserEntry.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        val idPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_ID)
        val fnamePos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_FIRST_NAME)
        val lnamePos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_LAST_NAME)
        val unamePos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_USER_NAME)
        val emailPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_EMAIL)
        val phoPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_PHONE_NO)
        val genPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_GENDER)
        val pasPos = cursor.getColumnIndex(UMContract.UserEntry.COLUMN_PASSWORD)

        while (cursor.moveToNext()){
            val id = cursor.getString(idPos)
            val fName = cursor.getString(fnamePos)
            val lName = cursor.getString(lnamePos)
            val uName = cursor.getString(unamePos)
            val ema = cursor.getString(emailPos)
            val phone = cursor.getString(phoPos)
            val gen = cursor.getString(genPos)
            val pass = cursor.getString(pasPos)

            users.add(User(id,fName,lName,uName,ema,phone,gen,pass))

        }

        cursor.close()
        return users
    }

}