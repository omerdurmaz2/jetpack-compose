package com.example.projectthree.service

import com.example.projectthree.model.Crypto
import com.example.projectthree.model.CryptoList
import com.example.projectthree.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {
    @GET("prices")
    suspend fun getCryptoList(
        @Query("key") key: String = Constants.API_KEY
    ): CryptoList

    @GET("currencies")
    suspend fun getCrypto(
        @Query("key") key: String = Constants.API_KEY,
        @Query("ids") id: String,
        @Query("attributes") attributes: String
    ): Crypto
}