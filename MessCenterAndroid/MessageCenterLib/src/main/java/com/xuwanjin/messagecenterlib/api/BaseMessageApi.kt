package com.xuwanjin.messagecenterlib.api

import com.google.gson.Gson
import com.xuwanjin.messagecenterlib.entity.BaseMessage
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BaseMessageApi {

    @GET
    suspend fun getMessageList():List<BaseMessage>

    companion object {
        private const val BASE_URL = ""
        fun create(): BaseMessageApi {
            val client = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BaseMessageApi::class.java)
        }
    }
}