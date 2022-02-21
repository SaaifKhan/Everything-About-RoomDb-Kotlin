package com.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Array.get
import java.lang.reflect.Array.set

@Entity(tableName = "users")

data class User(
    @PrimaryKey
    var id: Int?,


    @ColumnInfo(name = "user_name")
    var name: String?,
    @ColumnInfo(name = "user_email")
    var email: String
) {

    constructor() : this(-1, null, null.toString())


}
