package com.example.ecommerce.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.ecommerce.data.Product
import com.example.ecommerce.domain.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: ProductUseCase) : ViewModel() {

    var list = MutableLiveData<PagingData<Product>>()
    fun getData() {
        viewModelScope.launch {
            useCase.invoke().collect{
                it.data?.collect {
                    list.value = it
                }
            }
        }
    }

}