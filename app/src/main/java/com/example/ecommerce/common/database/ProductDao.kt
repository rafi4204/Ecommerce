package com.example.ecommerce.common.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.ecommerce.data.Product


@Dao
interface ProductDao {

    @Insert(onConflict = REPLACE)
    suspend fun savePosts(products: List<Product>)

    @Query("SELECT * FROM product")
    fun getPosts(): PagingSource<Int, Product>

    @Query("DELETE FROM product")
    suspend fun clearAllProduct()
}
