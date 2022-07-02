package com.example.projectthree.di

import com.example.projectthree.repository.CryptoRepository
import com.example.projectthree.service.CryptoApi
import com.example.projectthree.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCryptoRepository(api: CryptoApi) = CryptoRepository(api)

    @Singleton
    @Provides
    fun provideCryptoApi(): CryptoApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
            )
            .build()
            .create(CryptoApi::class.java)
    }
}