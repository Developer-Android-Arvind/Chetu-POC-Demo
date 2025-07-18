package com.easy_ride.navigation

import kotlinx.serialization.Serializable

interface AppDestinations {
    @Serializable
    object Login : AppDestinations

    @Serializable
    object Register : AppDestinations
}