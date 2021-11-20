package com.example.ocean_tech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await

data class Objetivos (
    val name: String = "",
        )

class MainActivity : AppCompatActivity() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val document = Firebase.firestore.collection(" coroutines").document("doc")
        val objetivo1 = Objetivos("Erradicação da Pobreza")
        val objetivo2 = Objetivos("Fome Zero e Agricultura Sustentável")
        val objetivo3 = Objetivos("Saúde e Bem-estar")
        val objetivo4 = Objetivos("Educação de Qualidade")
        val objetivo5 = Objetivos("Água Potável e Saneamento")
        val objetivo6 = Objetivos("Energia Acessível e Limpa")
        GlobalScope.launch(Dispatchers.IO) {
            delay(3000L)
            document.set(objetivo1).await()
           val obj = document.get().await().toObject(Objetivos::class.java)
            withContext(Dispatchers.Main) {
                val texto1 = findViewById<TextView>(R.id.texto1)
                if (obj != null) {
                    texto1.text = obj.name.toString()
                }
                document.set(objetivo2).await()
                val texto2 = findViewById<TextView>(R.id.texto2)
                if (obj != null) {
                    texto2.text = "Agricultura Sustentável"
                }
                val texto3 = findViewById<TextView>(R.id.texto3)
                if (obj != null) {
                    texto3.text = "Saúde e Bem-estar"
                }
                val texto4 = findViewById<TextView>(R.id.texto4)
                if (obj != null) {
                    texto4.text = "Educação de Qualidade"
                }
                val texto5 = findViewById<TextView>(R.id.texto5)
                if (obj != null) {
                    texto5.text = "Água Potável e Saneamento"
                }
                val texto6 = findViewById<TextView>(R.id.texto6)
                if (obj != null) {
                    texto6.text = "Energia Acessível e Limpa"
                }
            }
        }
    }
}