package com.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class MyDatabase : RoomDatabase() {
    abstract fun myDao(): MyDao?
}