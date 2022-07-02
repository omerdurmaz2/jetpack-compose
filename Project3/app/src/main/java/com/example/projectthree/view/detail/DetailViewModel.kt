package com.example.projectthree.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectthree.model.Crypto
import com.example.projectthree.model.CryptoItem
import com.example.projectthree.repository.CryptoRepository
import com.example.projectthree.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id: String): Resource<Crypto> {
        return repository.getCrypto(id)
    }

}