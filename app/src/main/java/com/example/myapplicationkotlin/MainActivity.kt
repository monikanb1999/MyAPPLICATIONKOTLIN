package com.example.myapplicationkotlin

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
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
import com.example.myapplicationkotlin.databinding.DetailsBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity(), Handler {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SchoolAdapter


    private  val viewmodel: MainViewModel by lazy {
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

        //observe
        viewmodel.studentlist.observe(this, androidx.lifecycle.Observer {
            Log.d("listsize", "onCreate: ${it.size}")
            if(it.isNotEmpty()){
                adapter.studentlist=it
                adapter.notifyDataSetChanged()
            }
        })

    }
    override fun onAddClicked(view: View) {
        if (!TextUtils.isEmpty(binding.name.text.toString())) {
            val table1 = apptable(
                0, binding.name.text.toString(),
                binding.age.text.toString().toInt(), Calendar.getInstance().timeInMillis, binding.school.text.toString()
            )
            viewmodel.inserttable(table1)
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
      class SchoolAdapter (context: Context) :RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>(){
         private val inflater:LayoutInflater = LayoutInflater.from(context)
            var studentlist = emptyList<apptable>()
         inner class SchoolViewHolder(val binding: DetailsBinding) : RecyclerView.ViewHolder(binding.root)

         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {

             val binding:DetailsBinding = DataBindingUtil.inflate(inflater,R.layout.details,parent,false)
             return SchoolViewHolder((binding))
         }

         override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
//             holder.binding.setVariable(BR.student, studentlist[position])

         //observe
             holder.binding.tvname.text= studentlist[position].name
             holder.binding.tvage.text= studentlist[position].age.toString()
             holder.binding.tvschool.text= studentlist[position].school
             holder.binding.executePendingBindings()

         }

         override fun getItemCount(): Int {
        //observer
         return studentlist.size
         }

     }
    }