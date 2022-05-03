package com.example.ecommerce.common.di.module

import android.content.Context
import com.example.ecommerce.common.database.ProductDatabase
import com.example.ecommerce.common.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class RetrofitClass {
    @Provides
    fun getRetrofit(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun getDatabase(@ApplicationContext context: Context) = ProductDatabase.create(context)

}