package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val name1 = findViewById<EditText>(R.id.player1)
        val name2 = findViewById<EditText>(R.id.player2)
        button.setOnClickListener{
            if (name1.text.isEmpty() || name2.text.isEmpty()) {
                if(name1.text.isEmpty()){
                    name1.error = "You must enter the name"
                }
                if(name2.text.isEmpty()){
                    name2.error = "You must enter the name"
                }
            } else {
                Intent(this, SecondActivity::class.java).also{
                    it.putExtra("EXTRA_NAME1", name1.text.toString())
                    it.putExtra("EXTRA_NAME2", name2.text.toString())
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}