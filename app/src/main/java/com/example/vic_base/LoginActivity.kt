package com.example.vic_base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var edtemail:EditText
    lateinit var edtpass:EditText
    lateinit var btnlogin:Button
    lateinit var btnregister:Button
    lateinit var btn:Button

    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtemail = findViewById(R.id.edt_email)
        edtpass = findViewById(R.id.edt_pass)
        btnlogin = findViewById(R.id.btn_login)
        btnregister = findViewById(R.id.btn_register)
        btn = findViewById(R.id.button)

        auth = FirebaseAuth.getInstance()




        btnlogin.setOnClickListener {

            var email = edtemail.text.toString().trim()
            var password = edtpass.text.toString().trim()

            if (email.isEmpty()|| password.isEmpty()){

                Toast.makeText(this, "One of the inputs is empty", Toast.LENGTH_SHORT).show()
            }else{
                
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()
                        
                    }else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
                
            }

        }

        btnregister.setOnClickListener {

            var gotoreg = Intent(this, Register::class.java)
            startActivity(gotoreg)

        }
        btn.setOnClickListener {
            var gotoimageview = Intent(this, image::class.java)
            startActivity(gotoimageview)
        }

    }
}