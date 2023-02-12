package com.example.obtenernumero

import android.Manifest
import android.app.Activity
import android.app.ActivityManager
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.telephony.TelephonyManager
import android.view.View.inflate
import android.view.inputmethod.InputBinding
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat.inflate




class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.editTextTextMultiLine)

        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_PHONE_STATE), 111)
        else
            getTelephonyDetail()

    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==111 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            getTelephonyDetail()
    }

    private fun getTelephonyDetail() {

        var tm : TelephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        var data:String  =  tm.deviceSoftwareVersion+"\n"+tm.simSerialNumber+"\n"+tm.networkCountryIso+"\n"+tm.networkOperatorName
        var phonetype:Int = tm.phoneType
        when(phonetype) {
            TelephonyManager.PHONE_TYPE_CDMA -> data = data + "CDMA\n"
            TelephonyManager.PHONE_TYPE_GSM -> data = data + "GSM\n"
            TelephonyManager.PHONE_TYPE_NONE -> data = data + "NONE\n"
        }

        val textText = findViewById<TextView>(R.id.editTextTextMultiLine)
        textText.setText(data)




    }
}