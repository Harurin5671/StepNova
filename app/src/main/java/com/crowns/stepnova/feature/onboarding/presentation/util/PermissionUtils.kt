package com.crowns.stepnova.feature.onboarding.presentation.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

fun getRequiredPermissions(): List<String> {
    val permissions = mutableListOf<String>()
    // ACTIVITY_RECOGNITION is needed from Android 10 (API 29)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        permissions.add(Manifest.permission.ACTIVITY_RECOGNITION)
    }
    // POST_NOTIFICATIONS is needed from Android 13 (API 33)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        permissions.add(Manifest.permission.POST_NOTIFICATIONS)
    }
    return permissions
}

fun arePermissionsGranted(context: Context): Boolean {
    return getRequiredPermissions().all {
        context.checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
    }
}
