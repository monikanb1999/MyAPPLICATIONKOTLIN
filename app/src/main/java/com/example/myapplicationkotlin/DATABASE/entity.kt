package com.example.myapplicationkotlin.DATABASE

import androidx.databinding.BaseObservable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablename")
data class apptable(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name="age")
    val age: String,
    @ColumnInfo(name = "datetime")
    val datatime: Long,
    @ColumnInfo(name = "school")
    val school: String
): BaseObservable()
