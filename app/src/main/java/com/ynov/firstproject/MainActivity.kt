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
        Log.i(MainActivity::class.simpleName, getString(R.string.text_on_create))
    }

    override fun onStart() {
        super.onStart()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_on_start))
    }

    override fun onResume() {
        super.onResume()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_on_resume))
    }

    override fun onStop() {
        super.onStop()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_on_stop))
    }

    override fun onPause() {
        super.onPause()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_on_pause))
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_on_restart))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_on_destroy))
    }

    override fun finish() {
        super.finish()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_finish))
    }

    override fun isFinishing(): Boolean {
        Log.i(MainActivity::class.simpleName, getString(R.string.text_is_finishing))
        return super.isFinishing()
    }
}