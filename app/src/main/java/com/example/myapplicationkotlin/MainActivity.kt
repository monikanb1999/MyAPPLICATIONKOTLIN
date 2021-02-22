package com.example.myapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationkotlin.DATABASE.apptable
import com.example.myapplicationkotlin.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Handler {
    lateinit var binding: ActivityMainBinding

    private  val viewmodel1: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.handler1 = this
    }
      override fun onAddClicked(view: View) {
          if (!TextUtils.isEmpty(binding.name.text.toString())) {
              val table1 = apptable(
                  0, binding.name.text.toString(),
                  binding.age.text.toString(), Calendar.getInstance().timeInMillis, binding.school.text.toString()
              )
              viewmodel1.inserttable(table1)
          } else {
              Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_LONG).show()
          }

      }

    }