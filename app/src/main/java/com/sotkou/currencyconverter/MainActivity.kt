package com.sotkou.currencyconverter

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Δηλώνουμε τις μεταβλητές σε επίπεδο class
    // για να ειναι ορατές σε όλη την κλάση
    lateinit var editText: EditText // πεδίο ποσού
    lateinit var convButton: Button // Κουμπί μετατροπής
    lateinit var textView: TextView // Τίτλος
    lateinit var rateText: EditText // ισοτιμία

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Αρχικοποιούμε τις μεταβλητές
        editText = findViewById(R.id.editText)
        convButton = findViewById(R.id.convertButton)
        textView = findViewById(R.id.textView)
        rateText = findViewById(R.id.rateEditText)


        // μεταβλητή που δέχεται το String(!) του ποσού $ που εισάγει ο χρήστης
        var amount = editText.text
        var rate = rateText.text

        // Lambda expression που καλείται όταν κάνουμε κλίκ στο κουμπί
        convButton.setOnClickListener{
            if (TextUtils.isEmpty(editText.text) || TextUtils.isEmpty(rateText.text))
                Toast.makeText(this, "Empty field not allowed!", Toast.LENGTH_SHORT).show()
            else {
                // δημιουργία intent για να πλοηγηθούμε στην επόμενη οθόνη του αποτελέσματος
                var intent = Intent(this, ResultActivity::class.java)
                // Στέλνουμε το ποσό σε $ και μορφή String(!) στην ResultActivity
                intent.putExtra("Amount", "$amount")
                intent.putExtra("Rate", "$rate")
                // Ξεκινάμε την ResultActivity
                startActivity(intent)
            }
        }

    }
}