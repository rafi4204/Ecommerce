package com.example.ecommerce.common.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.ecommerce.data.ProductKeys


@Dao
interface ProductKeysDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveRedditKeys(redditKey: List<ProductKeys>)

    @Query("SELECT * FROM productKeys WHERE repoId = :id")
    suspend fun remoteKeysDoggoId(id: String): ProductKeys?

    @Query("DELETE FROM productKeys")
    suspend fun clearRemoteKeys()

}
