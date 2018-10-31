package com.lucasnobile.myapp.presentation.ext

import android.support.annotation.StringRes
import android.support.v4.app.FragmentActivity
import android.widget.Toast

/**
 * FragmentActivity Extension functions to show a Toast message
 */
fun FragmentActivity.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun FragmentActivity.showToast(@StringRes resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show()
}