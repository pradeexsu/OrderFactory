package com.wmall.orderfactory.data

import androidx.lifecycle.LiveData

class DataRepository(private val appDao: ProductDao) {
    val readAllData: LiveData<List<Product>>  = appDao.getAll()

    suspend fun addProduct(product: Product){
        appDao.insert(product)
    }

}