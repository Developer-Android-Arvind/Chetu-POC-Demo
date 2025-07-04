package com.easy_ride.util

import kotlinx.coroutines.flow.Flow

interface NetworkMonitor {
    var isOnLine: Flow<Boolean>
}