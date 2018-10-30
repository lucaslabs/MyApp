package com.kotlin4android.ext

import android.view.View
import android.widget.ProgressBar

/**
 * ProgressBar Extension function that makes the view visible
 */
fun ProgressBar.show() {
    this.visibility = View.VISIBLE
}

/**
 * ProgressBar Extension function that makes the view gone
 */
fun ProgressBar.hide() {
    this.visibility = View.GONE
}