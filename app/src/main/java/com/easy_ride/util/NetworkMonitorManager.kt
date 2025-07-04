package com.easy_ride.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class NetworkMonitorManager : NetworkMonitor {

    override var isOnLine: Flow<Boolean> = callbackFlow {

        return@callbackFlow
    }

}