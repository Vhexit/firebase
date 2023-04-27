package com.example.vic_base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    lateinit var ediname:EditText
    lateinit var ediaddress:EditText
    lateinit var edicode:EditText
    lateinit var btncreate:Button
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        ediname = findViewById(R.id.edt_name)
        ediaddress = findViewById(R.id.edt_address)
        edicode = findViewById(R.id.edt_code)
        btncreate = findViewById(R.id.btn_create)

        auth = FirebaseAuth.getInstance()




        btncreate.setOnClickListener {

            var name = ediname.text.toString().trim()
            var email = ediaddress.text.toString().trim()
            var password = edicode.text.toString().trim()




            if (name.isEmpty() || email.isEmpty() || password.isEmpty()){

                Toast.makeText(this, "One of the fields is not complete", Toast.LENGTH_SHORT).show()


            }else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    
                    
                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()


                        var gotologin = Intent(this, LoginActivity::class.java)
                        startActivity(gotologin)

                    }else{
                        Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()

                        Log.d("TAG", "error--->", it.exception)
                    }
                    
                    
                    
                }
            }






        }


    }
}