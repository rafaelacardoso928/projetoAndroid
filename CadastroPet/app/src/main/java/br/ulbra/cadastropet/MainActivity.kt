package br.ulbra.cadastropet

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
            R.id.etxtNomePet
        )

        val especie = findViewById<TextInputEditText>(
            R.id.etxtEspecie
        )

        val idade = findViewById<TextInputEditText>(
            R.id.etxtIdadePet
        )

        val botao = findViewById<Button>(
            R.id.btn_CadastrarPet
        )

        val resultado = findViewById<TextView>(
            R.id.txtResultado
        )

        // Ação do botão
        botao.setOnClickListener {

            // Pegando os dados digitados
            val nomePet = nome.text.toString()

            val especiePet = especie.text.toString()

            val idadePet = idade.text.toString()

            // Mostrando no Logcat
            println("Nome: $nomePet")
            println("Espécie: $especiePet")
            println("Idade: $idadePet anos")

            // Mostrando o resultado na tela
            resultado.text =
                "Cadastro realizado com sucesso! 🐾\n\n" +
                        "Nome: $nomePet\n" +
                        "Espécie: $especiePet\n" +
                        "Idade: $idadePet anos"
        }
    }
}

