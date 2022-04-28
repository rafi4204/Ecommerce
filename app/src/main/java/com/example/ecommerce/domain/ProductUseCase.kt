package com.example.ecommerce.domain

import com.example.ecommerce.common.Resource
import com.example.ecommerce.data.Product
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ActivityRetainedScoped
class ProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading<List<Product>>())
            val products = repository.getProduct()
            emit(Resource.Success<List<Product>>(products))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Product>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Product>>("Couldn't reach server. Check your internet connection."))
        }
    }
}