package com.example.roommvvmexempel1

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class AppDatabase  : RoomDatabase(){
    abstract fun itemDao() : ItemDao

    companion object{

        private var _instance: AppDatabase? = null

        fun getInstance(): AppDatabase{

            return _instance ?: synchronized(this){
                val instance = Room.databaseBuilder(App.context,
                    AppDatabase::class.java,
                    "shopping-items")
                    .fallbackToDestructiveMigration()
                    .build()

                _instance = instance
                instance
            }

        }
    }
}