package com.example.myapplicationkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationkotlin.DATABASE.DBroom
import com.example.myapplicationkotlin.DATABASE.repository_table
import com.example.myapplicationkotlin.DATABASE.apptable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val tableRespository:repository_table
    init {
        val dao = DBroom.getInstance(getApplication()).tabledao()
        tableRespository= repository_table(dao)
    }
    fun inserttable(table:apptable)= viewModelScope.launch(Dispatchers.IO) {
        tableRespository.inserttablerepository(table)
    }
}