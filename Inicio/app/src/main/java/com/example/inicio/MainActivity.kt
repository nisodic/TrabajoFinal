package com.example.inicio

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var bntBotonIniciar = findViewById<Button>(R.id.bntIniciar)
    var txtEmailC =findViewById<TextView>(R.id.txtUsuario)
    var txtPassC = findViewById<TextView>(R.id.txtPassword)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bntIniciarSs = findViewById(R.id.bntIniciar) as Button

        bntIniciarSs.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clic me", Toast.LENGTH_SHORT).show()
        }



    /*    fun sendMessage(view: View){
            val editText =findViewById<EditText>(R.id.txtUsuario)
            val message = editText.text.toString()
            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)

            }
            startActivity(intent)
        }


    }*/

    /*bnt.SetOnClickListener{ it: View!
        val email = txtEmailC.text.toString()
        val pass = txtPassC.text.toString()
        if( email.isNotEmpty() && pass.isNotEmpty()){
            if(it.isSuccessful){
                val intent = Intent(packegeContext:this, MainActivity::class.java)
                startActivity(intent)
            }else  {
                Toast.makeText(context: this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun onStart(){
        super.onStart()

        if (){
            val intent = Intent(packageContext: this, MainActivity::class.java)
            startActivity(intent)
        }
    }*/
}