package com.easy_ride.data.model

data class User(
    val id: Int = 0,
    var userName: String = "",
    var email: String = "",
    var phone: String = "",
    var aadhaarNumber: String = "",
    var password: String = ""
) {

    fun getUserEmpty(): User {
        return User()
    }

}