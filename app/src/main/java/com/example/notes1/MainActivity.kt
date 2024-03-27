package com.example.notes1

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val BUNDLE_KEY ="MY_INT_KEY"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    fun report(s: String) = Log.d("MAIN_ACTIVITY", s)
    var clickCount = 0
    var result =""
    var solution =""

    lateinit var button_C: Button
    lateinit var button_left_brack: Button
    lateinit var button_right_brack: Button
    lateinit var button_del: Button
    lateinit var button_plus: Button
    lateinit var button_minus: Button
    lateinit var button_mult: Button
    lateinit var button_equal: Button
    lateinit var button_0: Button
    lateinit var button_1: Button
    lateinit var button_2: Button
    lateinit var button_3: Button
    lateinit var button_4: Button
    lateinit var button_5: Button
    lateinit var button_6: Button
    lateinit var button_7: Button
    lateinit var button_8: Button
    lateinit var button_9: Button
    lateinit var button_clear: Button
    lateinit var button_comma: Button
    lateinit var result_vw:TextView
    lateinit var solution_vw:TextView




    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        report("onCreate")
        solution_vw = findViewById(R.id.solution_vw)
        result_vw = findViewById(R.id.result_vw)

        button_C           = findViewById<Button>(R.id.button_ac)
        button_left_brack  = findViewById<Button>(R.id.button_close_bracket)
        button_right_brack = findViewById<Button>(R.id.button_open_bracket)
        button_del         =       findViewById<Button>(R.id.button_del)
        button_plus        = findViewById<Button>(R.id.button_plus)
        button_minus       = findViewById<Button>(R.id.button_minus)
        button_mult        = findViewById<Button>(R.id.button_mult)
        button_equal      = findViewById<Button>(R.id.button_equal)
        button_0             = findViewById<Button>(R.id.button_0)
        button_1             = findViewById<Button>(R.id.button_1)
        button_2             = findViewById<Button>(R.id.button_2)
        button_3             = findViewById<Button>(R.id.button_3)
        button_4             = findViewById<Button>(R.id.button_4)
        button_5             = findViewById<Button>(R.id.button_5)
        button_6             = findViewById<Button>(R.id.button_6)
        button_7             = findViewById<Button>(R.id.button_7)
        button_8             = findViewById<Button>(R.id.button_8)
        button_9             = findViewById<Button>(R.id.button_9)
        button_clear        = findViewById<Button>(R.id.button_clear)
        button_comma        = findViewById<Button>(R.id.button_comma)
        button_C.setOnClickListener(this)
        button_left_brack.setOnClickListener(this)
        button_right_brack.setOnClickListener(this)
        button_del.setOnClickListener(this)
        button_plus.setOnClickListener(this)
        button_minus.setOnClickListener(this)
        button_mult.setOnClickListener(this)
        button_equal.setOnClickListener(this)
        button_0.setOnClickListener(this)
        button_1.setOnClickListener(this)
        button_2.setOnClickListener(this)
        button_3.setOnClickListener(this)
        button_4.setOnClickListener(this)
        button_5.setOnClickListener(this)
        button_6.setOnClickListener(this)
        button_7.setOnClickListener(this)
        button_8.setOnClickListener(this)
        button_9.setOnClickListener(this)
        button_clear.setOnClickListener(this)
        button_comma.setOnClickListener(this)


        /*
        button.setOnClickListener {
            button.text = "Clicks ${++clickCount}"
        }
        */


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
        //button.text = "Clicks $clickCount"
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

    override fun onClick(v: View?) {
        var button:Button = v as Button
        var buttonText = button.getText().toString()
        var data = solution_vw.getText().toString()
        if (buttonText.equals("AC")){
            solution_vw.setText("")
            result_vw.setText("0")
            return
        }

        if(buttonText.equals("=")){
            solution_vw.setText(result_vw.getText())
            return
        }
        if(buttonText.equals("C")){
            data=data.substring(0,data.length-1);
        }else{
            data=data+buttonText
        }




        solution_vw.setText(data)

    }
}