package com.lib.in_app_updates

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    companion object {
        private const val SHARED_PREFERENCES_NAME = "ForceUpdateSharedPreferences"

        const val PREVIOUS_ASKED_FOR_UPDATE = "PREVIOUS_ASKED_FOR_UPDATE"
    }

    private val preferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    var previousAskedForUpdate: Long
        get() = preferences.getLong(PREVIOUS_ASKED_FOR_UPDATE, 0)
        set(value) {
            editor.putLong(PREVIOUS_ASKED_FOR_UPDATE, value)
            editor.apply()
        }

}