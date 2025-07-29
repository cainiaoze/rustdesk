package com.carriez.flutter_hbb

import android.accessibilityservice.AccessibilityService
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.view.accessibility.AccessibilityEvent
import android.util.Log;
import android.widget.TextView

private const val TAG="AttackDemo"
class MonitorService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) {
            return
        }
//        if ("com.tencent.mm" != event?.packageName && "cmb.pb" != event?.packageName) {
//            return;
//        }
        when (event.eventType) {
            AccessibilityEvent.TYPE_VIEW_CLICKED -> {
                Log.i(TAG, "TYPE_VIEW_CLICKED, text: " + event.text)
            }
            AccessibilityEvent.TYPE_VIEW_LONG_CLICKED -> Log.i(TAG, "TYPE_VIEW_LONG_CLICKED, text:" + event.text)
            else -> Log.i(TAG, "unknown event Type: " + event.eventType.toString())
        }
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }
    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.i(TAG, "onServiceConnected")
    }

}