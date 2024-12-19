package com.example.roommvvmexempel1

import kotlinx.coroutines.flow.Flow

class ItemRepository {

    private val itemDao = AppDatabase.getInstance().itemDao()

    val items: Flow<List<Item>> = itemDao.getAll()

    suspend fun updateItem(item: Item){
        itemDao.update(item)
    }

    fun delteItem(item:Item){
        itemDao.delete(item)
    }

    fun addItem(item:Item){
        itemDao.insert(item)
    }
}