package com.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEntry(model:User)


    @Query("SELECT * FROM users")
    fun getAllItem(): List<User>


    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?)



}