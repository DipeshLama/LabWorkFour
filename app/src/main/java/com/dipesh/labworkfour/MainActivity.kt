package com.dipesh.labworkfour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private  lateinit var etEmpName:EditText
    private lateinit var spinner:Spinner
    private lateinit var etAddress:EditText
    private lateinit var etJoinDate:EditText
    private lateinit var btnSubmit:Button
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
        btnSubmit.setOnClickListener {

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
                    val selectedItem=parent?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }
}