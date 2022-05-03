package com.example.ecommerce.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.ecommerce.common.database.ProductDatabase
import com.example.ecommerce.common.database.ProductRemoteMediator
import com.example.ecommerce.common.network.ApiService
import com.example.ecommerce.common.utils.AppHelper.DEFAULT_PAGE_SIZE
import com.example.ecommerce.domain.ProductRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class ProductRepoImp @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: ProductDatabase
) : ProductRepository {
    override suspend fun getProduct(): List<Product> {
        return apiService.getProducts()
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }



   override fun letProductFlowDb(): Flow<PagingData<Product>> {
        if (appDatabase == null) throw IllegalStateException("Database is not initialized")

        val pagingSourceFactory = { appDatabase.productDao().getPosts() }
        return Pager(
            config = getDefaultPageConfig(),
            pagingSourceFactory = pagingSourceFactory,
            remoteMediator = ProductRemoteMediator(apiService, appDatabase)
        ).flow
    }
}