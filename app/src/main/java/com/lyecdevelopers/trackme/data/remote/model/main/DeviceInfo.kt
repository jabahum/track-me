package com.lyecdevelopers.trackme.data.remote.model.main

import java.io.Serializable

class DeviceInfo : Serializable {
    var device: String? = null
    var os_version: String? = null
    var app_version: String? = null
    var serial: String? = null
    var regid: String? = null
}