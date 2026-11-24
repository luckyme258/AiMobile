package com.pocketpal.api

import android.content.Intent
import androidx.core.content.ContextCompat
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.pocketpal.specs.NativeApiKeepAliveSpec

@ReactModule(name = NativeApiKeepAliveSpec.NAME)
class ApiKeepAliveModule(reactContext: ReactApplicationContext) :
    NativeApiKeepAliveSpec(reactContext) {

    override fun start() {
        val context = reactApplicationContext.applicationContext
        ContextCompat.startForegroundService(
            context,
            Intent(context, ApiKeepAliveService::class.java),
        )
    }

    override fun stop() {
        val context = reactApplicationContext.applicationContext
        context.stopService(Intent(context, ApiKeepAliveService::class.java))
    }
}
