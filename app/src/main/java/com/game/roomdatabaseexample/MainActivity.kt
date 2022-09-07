package com.game.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            applicationContext, ContactDatabase::class.java,
            "contactDB"
        ).build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0, "Ketan", "9545442913"))
        }
    }

    fun getData(view: View) {
        database.contactDao().getContacts().observe(this@MainActivity, androidx.lifecycle.Observer {
            Log.d("KETAN", it.toString())
        })
    }
}
