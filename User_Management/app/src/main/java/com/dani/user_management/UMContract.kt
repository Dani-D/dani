package com.dani.user_management


import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object UMContract {


    object UserEntry : BaseColumns {
        const val TABLE_NAME = "User_Mg_Database_Table"
        const val COLUMN_ID = _ID
        const val COLUMN_FIRST_NAME = "first_name"
        const val COLUMN_LAST_NAME = "last_name"
        const val COLUMN_USER_NAME = "user_name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PHONE_NO = "phone_no"
        const val COLUMN_GENDER = "gender"
        const val COLUMN_PASSWORD = "password"

        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE $TABLE_NAME (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "$COLUMN_FIRST_NAME TEXT NOT NULL, "+
                    "$COLUMN_LAST_NAME TEXT NOT NULL, "+
                    "$COLUMN_USER_NAME TEXT NOT NULL, "+
                    "$COLUMN_EMAIL TEXT NOT NULL, "+
                    "$COLUMN_PHONE_NO TEXT NOT NULL, "+
                    "$COLUMN_GENDER TEXT NOT NULL, "+
                    "$COLUMN_PASSWORD TEXT NOT NULL)"

        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}
