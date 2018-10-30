package com.lucasnobile.myapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Laptop model class.
 *
 * @author lucas.nobile
 */
data class Laptop(val title: String,
                  val description: String,
                  @SerializedName("image")
                  val imageUrl: String)