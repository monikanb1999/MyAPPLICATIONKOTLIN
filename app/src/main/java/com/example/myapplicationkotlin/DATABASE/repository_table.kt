package com.example.myapplicationkotlin.DATABASE

import androidx.lifecycle.LiveData

class repository_table(private val tabledao: Dao_table)
{
    fun repositorytable(table: apptable): LiveData<List<apptable>> {
        return tabledao.gettable()
    }
    fun inserttablerepository(table: apptable){
        return tabledao.inserttable(table)
    }
}