package com.example.projectthree.repository

import com.example.projectthree.model.Crypto
import com.example.projectthree.model.CryptoList
import com.example.projectthree.service.CryptoApi
import com.example.projectthree.util.Constants
import com.example.projectthree.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api: CryptoApi
) {
    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(Constants.API_KEY)
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(
                Constants.API_KEY,
                id = id,
                Constants.CALL_ATTRIBUTES
            )
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}