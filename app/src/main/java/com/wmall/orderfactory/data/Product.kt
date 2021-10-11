package com.wmall.orderfactory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val productId: Int = 0,
    @ColumnInfo(name = "product_name") val productName: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "quantity") val quantity: String
)