package com.lucasnobile.myapp.data

import com.lucasnobile.myapp.data.model.Laptop
import retrofit2.http.GET
import retrofit2.Call

/**
 * API Client to perform requests to API.
 *
 * @author lucas.nobile
 */
interface ApiClient {

    companion object {
        const val baseApiUrl = "http://private-f0eea-mobilegllatam.apiary-mock.com/"
    }

    @GET("list")
    fun getLaptopList(): Call<Laptop>
}