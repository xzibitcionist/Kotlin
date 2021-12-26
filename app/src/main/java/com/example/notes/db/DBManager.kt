package com.example.notes.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DBManager(context: Context) {
    val dbHelper = DBHelper(context)
    var db:SQLiteDatabase? = null

    fun openDB(){
        db= dbHelper.writableDatabase
    }

    fun insertToDB(title:String, content: String){
        val values= ContentValues().apply {
            put(MyDBMameClass.COLUMN_NAME_TITLE, title)
            put(MyDBMameClass.COLUMN_NAME_CONTENT, content)

        }
        db?.insert(MyDBMameClass.TABLE_NAME,null,values)
    }

    fun readDBData():ArrayList<String>{
        val dataList = ArrayList<String>()
        val cursor = db?.query(MyDBMameClass.TABLE_NAME, null,null,null,
            null,null,null)

        while (cursor?.moveToNext()!!){
            val dataText = cursor.getString(cursor.getColumnIndex(MyDBMameClass.COLUMN_NAME_TITLE))
            dataList.add(dataText.toString())
        }
        cursor.close()
        return dataList
    }
    fun closeDB(){
        dbHelper.close()
    }
}