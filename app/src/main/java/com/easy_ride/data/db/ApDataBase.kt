package com.easy_ride.data.db

import androidx.room.Database
import com.easy_ride.data.dao.UserDao
import com.easy_ride.data.model.User


@Database(entities = [User::class], version = 1)
abstract class ApDataBase {
    abstract fun userDao(): UserDao


}