package com.example.ecommerce.common.di.module

import com.example.ecommerce.data.ProductRepoImp
import com.example.ecommerce.domain.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ProductRepoModule {

    @Binds
    abstract fun bindProductRepo(productRepoImpl: ProductRepoImp): ProductRepository
}