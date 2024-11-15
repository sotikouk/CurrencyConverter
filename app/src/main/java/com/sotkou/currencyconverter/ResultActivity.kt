package com.sotkou.currencyconverter

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultTextView = findViewById(R.id.textView2)

        var result = intent.getStringExtra("Amount")
        var rate = intent.getStringExtra("Rate")

        resultTextView.text = convert(result, rate) + " Euros"

    }

    private fun convert(usd: String?, rate: String?): String {
        val result = usd?.toDouble()?.div(rate?.toDouble()!!) // Ποσό δολάρια / ισοτιμία
        return "%.02f".format(result)
    }
}