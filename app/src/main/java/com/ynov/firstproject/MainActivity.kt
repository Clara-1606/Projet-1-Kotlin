package com.ynov.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Bouton qui affiche une info toast
        var buttonToast = findViewById<Button>(R.id.mainButton)
        buttonToast.setOnClickListener {
            Toast.makeText(this, R.string.text_toast, Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(MainActivity::class.simpleName, "ICI ON EST DANS LE START !")
    }
}