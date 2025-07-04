package com.easy_ride.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserDetail")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userName: String = "",
    val email: String = "",
    val phone: String = "",
    val aadhaarNumber: String = ""
)