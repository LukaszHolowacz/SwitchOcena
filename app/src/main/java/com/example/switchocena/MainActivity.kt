package com.example.switchocena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val do_sortowania: MutableList<Int> = mutableListOf()
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

        przypisywanie_wartosci(switche, teksty)

        los.setOnClickListener {
            if(!do_sortowania.isEmpty()){
                do_sortowania.clear()
            }
            przypisywanie_wartosci(switche, teksty)
        }

        sort.setOnClickListener {
            if(!do_sortowania.isEmpty()){
                do_sortowania.clear()
            }
            if(teksty[0].text != ""){
                for(i in 0..switche.size-1){
                    if(switche[i].isChecked){
                        do_sortowania.add(teksty[i].text.toString().toInt())
                    }
                }
                if(!do_sortowania.isEmpty()){
                    val posortowana_lista = sortowanie_babelkowe(do_sortowania, do_sortowania.size-1)
                    findViewById<TextView>(R.id.wynik).text = posortowana_lista.toString()
                }
                else{
                    Toast.makeText(applicationContext, "Musisz coś zaznaczyć, żeby to posortować!", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(applicationContext, "Najpierw musisz wylosować liczby!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun random_numbers(): MutableList<Int>{
    val randomValues: MutableList<Int> = emptyList<Int>().toMutableList()
        while(randomValues.size < 9){
            val rnd = Random.nextInt(1,10)
            if(!randomValues.contains(rnd)) {
                randomValues.add(rnd)
            }
        }
        return randomValues
    }

    fun przypisywanie_wartosci(lista1: List<Switch>, lista2: List<TextView>){
        val liczby = random_numbers()
        for(i in 0..lista1.size-1){
            lista1[i].isChecked = false
            lista2[i].text = liczby[i].toString()
        }
    }

    fun sortowanie_babelkowe(tab: MutableList<Int>, size: Int): MutableList<Int>{
        var pom: Int
        for(i in 0..size){
            for (j in 1..size){
                if(tab[j-1]>tab[j]){
                    pom = tab[j]
                    tab[j] = tab[j-1]
                    tab[j-1] = pom
                }
            }
        }
        return tab
    }
}