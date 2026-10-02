package br.ulbra.inscricao

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
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val nome = findViewById<TextInputEditText>(R.id.etxtNome)
        val email = findViewById<TextInputEditText>(R.id.etxtEmail)
        val idade = findViewById<TextInputEditText>(R.id.etxtIdade)

        val botao = findViewById<Button>(R.id.btn_Inscrever)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        botao.setOnClickListener {

            val nomeUsuario = nome.text.toString()
            val emailUsuario = email.text.toString()
            val idadeUsuario = idade.text.toString().toInt()

            println("Nome: $nomeUsuario")
            println("E-mail: $emailUsuario")
            println("Idade: $idadeUsuario")

            if (idadeUsuario < 14 || idadeUsuario > 99) {

                println("Idade inválida para o evento.")

                resultado.text =
                    "⚠️ Idade inválida!\n\nA idade permitida é de 14 a 99 anos."

            } else {

                println("Inscrição confirmada!")

                resultado.text =
                    "✓ Inscrição confirmada!\n\n$nomeUsuario, sua inscrição foi confirmada!"
            }
        }
    }
}