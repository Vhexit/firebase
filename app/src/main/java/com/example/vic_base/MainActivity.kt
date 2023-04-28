package com.example.vic_base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

   lateinit var edtcar:EditText
   lateinit var edtmodel:EditText
   lateinit var edtprice:EditText
   lateinit var btnphoto:Button
   lateinit var btndata:Button
   lateinit var btnview:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtcar = findViewById(R.id.edt_car)
        edtmodel = findViewById(R.id.edt_model)
        edtprice = findViewById(R.id.edt_price)
        btnphoto = findViewById(R.id.btn_car)
        btndata = findViewById(R.id.btn_data)
        btnview = findViewById(R.id.btn_view)


        //initialise firebase

        var database = FirebaseDatabase.getInstance()
        var databaseref = database.getReference("cars")

        btnphoto.setOnClickListener {

            var carmake = edtcar.text.toString().trim()
            var carmodel = edtmodel.text.toString().trim()
            var carprice = edtprice.text.toString().trim()

            if (carmake.isEmpty()||carmodel.isEmpty()||carprice.isEmpty()) {

                Toast.makeText(this, "Cannot Submit an Empty form", Toast.LENGTH_SHORT).show()

            }else{

                var usercar = Car(carmake,carmodel,carprice)
                var ref = FirebaseDatabase.getInstance().getReference().child("cars")
                
                ref.setValue(usercar).addOnCompleteListener{
                    
                    if (it.isSuccessful){
                        Toast.makeText(this, "Car Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
                        
                    }else{
                        Toast.makeText(this, "Failed to Save Car Info", Toast.LENGTH_SHORT).show()
                    }
                    
                }
                
            }
        }

        btndata.setOnClickListener {


        }

        btnview.setOnClickListener {


        }
    }
}