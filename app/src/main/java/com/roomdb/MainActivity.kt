package com.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    var fragmentManager: FragmentManager? = null
    var myAppDatabase: MyDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        myAppDatabase = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "userdb")
            .allowMainThreadQueries().build()

        if(findViewById<FrameLayout>(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return
            }
            fragmentManager!!.beginTransaction().add(R.id.fragment_container, HomeFragment())
                .commit()

        }

    }
}