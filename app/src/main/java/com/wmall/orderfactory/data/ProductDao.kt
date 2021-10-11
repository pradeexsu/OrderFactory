package com.wmall.orderfactory.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM product order by product_name desc")
    fun getAll(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

//    @Delete
//    suspend fun delete(product: Product)
}