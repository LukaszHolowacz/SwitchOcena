package com.example.switchocena

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var liczby: List<Int>
        val sort = findViewById<Button>(R.id.sortowanie)
        val los = findViewById<Button>(R.id.losowanie)
        val switche = listOf<Switch>(
            findViewById(R.id.switch1),
            findViewById(R.id.switch2),
            findViewById(R.id.switch3),
            findViewById(R.id.switch4),
            findViewById(R.id.switch5),
            findViewById(R.id.switch6),
            findViewById(R.id.switch7),
            findViewById(R.id.switch8),
            findViewById(R.id.switch9)
        )
        val teksty = listOf<TextView>(
            findViewById(R.id.text1),
            findViewById(R.id.text2),
            findViewById(R.id.text3),
            findViewById(R.id.text4),
            findViewById(R.id.text5),
            findViewById(R.id.text6),
            findViewById(R.id.text7),
            findViewById(R.id.text8),
            findViewById(R.id.text9)
        )

        for(i in 0..switche.size-1){
            switche[i].setOnClickListener {

            }
        }

        los.setOnClickListener {
            liczby = random_numbers()
            for(i in 0..switche.size-1){
                teksty[i].text = liczby[i].toString()
            }
        }
    }

    fun random_numbers(): List<Int>{
    val randomValues: List<Int> = emptyList()
        while(randomValues.size < 9){
            var rnd = Random.nextInt(0,9)
            if(!randomValues.contains(rnd)){
                
            }
        }
        return randomValues
    }
}