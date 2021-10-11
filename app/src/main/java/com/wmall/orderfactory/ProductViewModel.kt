package com.wmall.orderfactory

import android.app.Application
import androidx.lifecycle.*
import com.wmall.orderfactory.data.AppDatabase
import com.wmall.orderfactory.data.DataRepository
import com.wmall.orderfactory.data.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var products: LiveData<List<Product>>
    private lateinit var repository: DataRepository

    init {
        val daoObject = AppDatabase.getDatabase(
            application
        ).productDao()
        repository = DataRepository(daoObject)
        products = repository.readAllData
    }
    fun getProducts(): LiveData<List<Product>> {
        return products
    }
    fun addProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(product)
        }
        products = repository.readAllData
    }

}