package com.example.ecommerce.data

import com.example.ecommerce.common.network.ApiService
import com.example.ecommerce.domain.ProductRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class ProductRepoImp @Inject constructor(private val apiService: ApiService) : ProductRepository {
    override suspend fun getProduct(): List<Product> {
        return apiService.getProducts()
    }
}