package br.ulbra.reservasala

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Ligando os campos do XML ao Kotlin

        val nome = findViewById<TextInputEditText>(
            R.id.etxtNome
        )

        val sala = findViewById<TextInputEditText>(
            R.id.etxtSala
        )

        val horario = findViewById<TextInputEditText>(
            R.id.etxtHorario
        )

        val botao = findViewById<Button>(
            R.id.btn_Reservar
        )

        val resultado = findViewById<TextView>(
            R.id.txtResultado
        )

        // Ação do botão

        botao.setOnClickListener {

            // Pegando os dados digitados

            val nomeUsuario =
                nome.text.toString()

            val salaUsuario =
                sala.text.toString()

            val horarioUsuario =
                horario.text.toString()

            // Mostrando no Logcat

            println("Responsável: $nomeUsuario")
            println("Sala: $salaUsuario")
            println("Horário: $horarioUsuario")

            // Mostrando o resultado na tela

            resultado.text =
                "Reserva confirmada! 📅\n\n" +
                        "Sala: $salaUsuario\n" +
                        "Responsável: $nomeUsuario\n" +
                        "Horário: $horarioUsuario"
        }
    }
}
