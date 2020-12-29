package com.dipesh.labworkfour

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    private  lateinit var etEmpName:EditText
    private lateinit var spinner:Spinner
    private lateinit var etAddress:EditText
    private lateinit var etJoinDate:EditText
    private lateinit var btnSubmit:Button
    lateinit var selectedItem:String
    val departments= arrayOf("Computer Science",
        "Management", "Network","Academic")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etEmpName=findViewById(R.id.etEmpName)
        spinner=findViewById(R.id.spinner)
        etAddress=findViewById(R.id.etAddress)
        etJoinDate=findViewById(R.id.etJoinDate)
        btnSubmit=findViewById(R.id.btnSubmit)

        spinner()

        etJoinDate.setOnClickListener {
            joinDate()
        }

        btnSubmit.setOnClickListener {
            val name=etEmpName.text
            val address=etAddress.text
            val builder=AlertDialog.Builder(this)
            builder.setTitle("Employee information")
            builder.setMessage("Employee Name: $name\n\nDepartment: $selectedItem\n\nAddress: $address\n\nJoin date: ${etJoinDate.text} ")
            builder.setNegativeButton("Close"){
                dialogInterface,which->
            }
            val alertDialog:AlertDialog=builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }

    private fun spinner(){
        val arrayAdapter=ArrayAdapter(this, android.R.layout.simple_list_item_1,
            departments)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener=
            object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                     selectedItem=parent?.getItemAtPosition(position).toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }

    private fun joinDate(){
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get (Calendar.DAY_OF_MONTH)
        val datePickerDialog=DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                etJoinDate.setText("$dayOfMonth/${month+1}/$year")
            },year, month,day
            )
        datePickerDialog.show()
    }
}