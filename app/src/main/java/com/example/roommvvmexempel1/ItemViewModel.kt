package com.example.roommvvmexempel1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel: ViewModel() {

    private val repo = ItemRepository()


    //read
    val items: LiveData<List<Item>> get() = repo.items.asLiveData()


    //create
    fun saveItem(item: Item) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.addItem(item)

        }


    //update
    fun updateItem(item: Item) = viewModelScope.launch(Dispatchers.IO) {
        repo.updateItem(item)
    }



    //delete
    fun deleteItem(item: Item) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.delteItem(item)
        }


}