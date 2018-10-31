package com.lucasnobile.myapp.presentation.ext

import android.widget.ImageView
import com.lucasnobile.myapp.R
import com.squareup.picasso.Picasso

fun ImageView.loadFromUrl(url: String) {
    Picasso.get()
            .load(url)
            .placeholder(R.mipmap.ic_launcher_round)// optional
            // TODO .error(R.drawable.sync)
            .into(this)
}