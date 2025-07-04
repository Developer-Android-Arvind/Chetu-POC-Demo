package com.easy_ride.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easy_ride.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM UserDetail WHERE userName = :userName")
    suspend fun getUserDetailByName(userName:String):User

    @Query("SELECT * FROM UserDetail")
    suspend fun getAllUserList(): List<User>

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertUser(user: User)
}