package com.example.projetocma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PaymentAcknowledgment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_acknowledgment)

        val textViewMessage1 = findViewById<TextView>(R.id.textViewMessage1)
        val textViewMessage2 = findViewById<TextView>(R.id.textViewMessage2)
        val textViewMessage3 = findViewById<TextView>(R.id.textViewMessage3)


        textViewMessage1.text = "THANKS"
        textViewMessage2.text = "CHECK YOUR EMAIL FOR TICKET CONFIRMATION."
        textViewMessage3.text = "WE WAIT FOR YOU"
    }
}