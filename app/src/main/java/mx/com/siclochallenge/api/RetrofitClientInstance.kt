/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private const val BASE_URL = "https://api.siclo.com"

    private val retrofit: Retrofit = retrofit2.Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    /**
     * Gets Retrofit client
     *
     * @return Retrofit client
     */
    fun getClient() = retrofit
}