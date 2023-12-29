package com.example.mysharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user=binding.user
        val pass=binding.pass
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener {
            val sharedPreferences:SharedPreferences=getSharedPreferences("myData",Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()
            editor.putString("u",user.text.toString())
            editor.putString("p",pass.text.toString())
            editor.apply()
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }
        binding.load.setOnClickListener {
            val sharedPreferences:SharedPreferences=getSharedPreferences("myData",Context.MODE_PRIVATE)

            val userName=sharedPreferences.getString("u","None")
            val password=sharedPreferences.getString("p","")
            user.setText(userName)
            pass.setText(password)


        }
    }
}