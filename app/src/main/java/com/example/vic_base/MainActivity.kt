package com.example.vic_base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var edttext:EditText
    lateinit var btn_button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edttext = findViewById(R.id.edt_text)
        btn_button = findViewById(R.id.btn)

        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference

        btn_button.setOnClickListener {


            var user_data = edttext.text.toString().trim()
           // Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
            databaseRef.setValue(user_data)
        }


    }
}