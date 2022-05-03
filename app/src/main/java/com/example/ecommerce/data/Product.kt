package com.example.ecommerce.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Product(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rate
) : Serializable
