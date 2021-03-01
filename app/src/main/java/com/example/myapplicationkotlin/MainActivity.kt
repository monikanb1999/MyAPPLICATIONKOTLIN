package com.example.myapplicationkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationkotlin.DATABASE.apptable
import com.example.myapplicationkotlin.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity(), Handler {
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SchoolAdapter


    private  val viewer1: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.handler1=this

        adapter= SchoolAdapter(this)
        binding.recyclerView?.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView?.layoutManager = layoutManager
        binding.recyclerView?.adapter = adapter
    }
    override fun onAddClicked(view: View) {
        if (!TextUtils.isEmpty(binding.name.text.toString())) {
            val table1 = apptable(
                0, binding.name.text.toString(),
                binding.age.text.toString(), Calendar.getInstance().timeInMillis, binding.school.text.toString()
            )
            viewer1.inserttable(table1)
            Toast.makeText(this,"please enter the fields",Toast.LENGTH_LONG).show()
                val snackbar = Snackbar.make(view, "Replace with your own action",
                    Snackbar.LENGTH_LONG).setAction("Action", null)
                snackbar.setActionTextColor(Color.BLUE)
                val snackbarView = snackbar.view
                snackbarView.setBackgroundColor(Color.LTGRAY)
                val textView =
                    snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                textView.setTextColor(Color.BLUE)
                textView.textSize = 15f
                snackbar.show()
            }         else {
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_LONG).show()
        }
    }
     class SchoolAdapter :RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>(){
         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
            val binding:
         }
//         private val inflater : LayoutInflater = LayoutInflater.from(context)
//
//         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
//             val binding:RegisterBinding = DataBindingUtil.inflate(inflater,R.layout.register,parent,false)
//             return RecyclerViewHolder((binding))
//         }

         override fun onBindViewHolder(holder: SchoolAdapter.SchoolViewHolder, position: Int) {
             TODO("Not yet implemented")
         }

         override fun getItemCount(): Int {
             TODO("Not yet implemented")
         }

     }
    }