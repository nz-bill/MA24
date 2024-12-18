package com.example.roommvvmexempel1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roommvvmexempel1.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Item>()
    lateinit var itemAdapter: ArrayAdapter<Item>
    lateinit var vm: ItemViewModel

//    private lateinit var job : Job
//    private lateinit var db : AppDatabase
//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this).get(ItemViewModel::class.java)

      //  job = Job()

//        db = Room.databaseBuilder(applicationContext,
//            AppDatabase::class.java,
//            "shopping-items")
//            .fallbackToDestructiveMigration()
//            .build()

//        db = AppDatabase.getInstance()

//        val item1 = Item(0, "banan", false, "frukt")
//        val item2 = Item(0, "mjölk", false, "kyl")
//        val item3 = Item(0, "ost", false, "kyl")

//        saveItem(item1)
//        saveItem(item2)
//        saveItem(item3)

        vm.items.observe(this){items ->
            itemList.clear()
            itemList.addAll(items)
            itemAdapter.notifyDataSetChanged()

        }

        itemAdapter = ItemAdapter(this, itemList)
        binding.lvItems.adapter = itemAdapter

        //loadAndDisplayAllItems()

        //val list = loadAllItems()
        //val list = loadByCategory("kyl")

        binding.btnAdd.setOnClickListener {
            if (binding.etName.text.isNotBlank() && binding.etCategory.text.isNotBlank()){
                val name = binding.etName.text.toString()
                val category = binding.etCategory.text.toString()

                val item = Item(0, name, false, category)
                vm.saveItem(item)
            }
        }

        binding.lvItems.onItemLongClickListener = AdapterView.OnItemLongClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as Item
            vm.deleteItem(item).isCompleted
        }


//    }

//    fun loadAndDisplayAllItems(){
//        launch {
//            val items = loadAllItems().await()
//            itemList.clear()
//            itemList.addAll(items)
//            itemAdapter.notifyDataSetChanged()

//            for(item in itemList) {
//                Log.d("!!!", "item: $item")
//            }
//        }
//    }

//    fun delete(item : Item) =
//        launch(Dispatchers.IO) {
//            db.itemDao().delete(item)
//            loadAndDisplayAllItems()
//        }
//
//    fun loadByCategory(category : String) : Deferred<List<Item>> =
//        async(Dispatchers.IO) {
//            db.itemDao().findByCategory(category)
//        }
//
////    fun loadAllItems() : Deferred<List<Item>> =
////        async(Dispatchers.IO) {
////            db.itemDao().getAll()
////        }
//
//    fun saveItem(item: Item) {
//        launch(Dispatchers.IO) {
//            db.itemDao().insert(item)
//            loadAndDisplayAllItems()
//
//        }
    }




}