package com.example.roommvvmexempel1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item (@PrimaryKey(autoGenerate = true) val id: Int,
            @ColumnInfo(name = "name") var name: String?,
            @ColumnInfo(name = "done") var done: Boolean = false,
            @ColumnInfo(name = "category") var category : String?
)