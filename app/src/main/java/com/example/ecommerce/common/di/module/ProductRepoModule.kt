package com.example.ecommerce.common.di.module

import com.example.ecommerce.data.ProductRepoImp
import com.example.ecommerce.domain.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductRepoModule {

    @Binds
    abstract fun bindProductRepo(productRepoImpl: ProductRepoImp): ProductRepository
}