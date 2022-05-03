package com.example.ecommerce.domain

import androidx.paging.PagingData
import com.example.ecommerce.common.Resource
import com.example.ecommerce.data.Product
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class ProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<Flow<PagingData<Product>>>> = flow {
        try {
            emit(Resource.Loading<Flow<PagingData<Product>>>())
            val products = repository.letProductFlowDb()
            emit(Resource.Success<Flow<PagingData<Product>>>(products))
        } catch (e: HttpException) {
            emit(Resource.Error<Flow<PagingData<Product>>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<Flow<PagingData<Product>>>("Couldn't reach server. Check your internet connection."))
        }
    }
}