package com.lucasnobile.myapp.domain.interactor

import com.lucasnobile.myapp.data.ApiClient
import com.lucasnobile.myapp.data.model.Laptop
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Interactor to load laptop list from API.
 *
 * @author lucas.nobile
 */
class LoadLaptopListInteractor(private val listener: ResponseListener) : Callback<List<Laptop>> {

    interface ResponseListener {
        fun onResponse(laptopList: List<Laptop>)

        fun onError(t: Throwable?)
    }


    private val loggingInterceptor: HttpLoggingInterceptor
    private val okClient: OkHttpClient
    private val apiClient: ApiClient

    init {
        loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okClient = OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .build()

        apiClient = Retrofit.Builder()
                .baseUrl(ApiClient.baseApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
                .build()
                .create(ApiClient::class.java)
    }

    fun execute() = apiClient.getLaptopList().enqueue(this)

    override fun onResponse(call: Call<List<Laptop>>?, response: Response<List<Laptop>>) {
        try {
            //  Using Non-Null Asserted Call to catch the exception in case of being a null reference
            if (response!!.isSuccessful && response.body() != null) {
                val laptopList = response.body() ?: emptyList()
                listener.onResponse(laptopList)
            }
        } catch (e: Exception) {
            listener.onError(e)
        }
    }

    override fun onFailure(call: Call<List<Laptop>>, t: Throwable) {
        listener.onError(t)
    }
}