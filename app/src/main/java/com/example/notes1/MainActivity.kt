package com.example.notes1

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val BUNDLE_KEY ="MY_INT_KEY"

class MainActivity : AppCompatActivity() {

    fun report(s: String) = Log.d("MAIN_ACTIVITY", s)
    var clickCount = 0
    lateinit var button: Button

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        report("onCreate")
        button = findViewById<Button>(R.id.hello_button)
        button.setOnClickListener {
            button.text = "Clicks ${++clickCount}"
        }

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(BUNDLE_KEY, clickCount)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        clickCount = savedInstanceState.getInt(BUNDLE_KEY,clickCount)
        button.text = "Clicks $clickCount"
    }
    override fun onStart() {
        super.onStart()
        report("onStart")
    }
    override fun onResume() {
        super.onResume()
        report("onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        report("onDestroy")
    }

    override fun onPause() {
        super.onPause()
        report("onPause")
    }

    override fun onStop() {
        super.onStop()
        report("onStop")
    }
}