package com.example.myapplicationkotlin.DATABASE

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao_table {
    @Insert
    fun inserttable(table: apptable)

    @Query("select * from tablename")
    fun gettable(): LiveData<List<apptable>>
}