package com.example.bindingdemov2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bindingdemov2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //lateinit is used when the value will only be assigned after this
    private lateinit var binding : ActivityMainBinding //only onCreate function is being called then only can use binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student = Student("W123", "Ali")

        //binds this kotlin file with activity main xml
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myData = student

        //after the binding above, now can directly use it like data field in xml = object.attributes
        //binding.tvStudentID.text = student.id
        //binding.tvStudentName.text = student.name

        binding.btnUpdate.setOnClickListener(){
            student.name = "Alex"
            //can do like this but not we want
            //binding.tvStudentName.text = student.name
            binding.apply {
                invalidateAll()
            }
        }

    }
}