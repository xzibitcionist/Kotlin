package com.example.notes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.notes.db.DBManager
import android.R
class MainActivity : AppCompatActivity() {

    val dbManager = DBManager(this)

//    val editTextTextPersonName3:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSave(view: View) {
        TVtest.text=""
        dbManager.openDB()
        dbManager.insertToDB(editTextTextPersonName3.text.toString(),editText.text.toString())
//        dbManager.insertToDB(edContent.text.toString())
        val dataList= dbManager.readDBData() //массив данных из БД
        for (item in dataList)

    }
    ovveride fun onDestroy(){
        super.onDestroy()
        dbManager.closeDB()
    }

}