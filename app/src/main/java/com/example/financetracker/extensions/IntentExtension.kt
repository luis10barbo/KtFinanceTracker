package com.example.financetracker.extensions

import android.content.Intent
import android.os.Build
import java.io.Serializable

fun <T: Serializable?> Intent.extGetSerializableExtra(key: String, m_class: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        this.extGetSerializableExtra(key, m_class)
    else
        this.getSerializableExtra(key) as T

}