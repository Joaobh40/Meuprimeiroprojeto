package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)


        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1F)

        tvResult.text = result.toString()

        /*   Menor que 18,5       Magreza 0
        Entre 18,5 e 24,9	Normal	0
        Entre 25,0 e 29,9	Sobrepeso
        Entre 30,0 e 39,9	Obesidade
        Maior que 40,0	    Obesidade Grave
        */

        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        } else if(result in 18.5f..24.9f) {
            "NORMAL"
        } else if(result in 25f..29.9f) {
            "SOBREPESO"
        } else if(result in 30f..39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classifiçao,classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
