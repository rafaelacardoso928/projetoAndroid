package br.ulbra.pedidos

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

        // Ligando os componentes do XML ao Kotlin
        val lanche = findViewById<TextInputEditText>(R.id.etxtLanche)

        val bebida = findViewById<TextInputEditText>(R.id.etxtBebida)

        val observacao =
            findViewById<TextInputEditText>(R.id.etxtObservacao)

        val botao = findViewById<Button>(R.id.btn_Pedir)

        val resultado = findViewById<TextView>(R.id.txtResultado)

        // Ação do botão
        botao.setOnClickListener {

            // Pegando os dados digitados
            val lancheUsuario =
                lanche.text.toString()

            val bebidaUsuario =
                bebida.text.toString()

            val observacaoUsuario =
                observacao.text.toString()

            // Mostrando no Logcat
            println("Lanche: $lancheUsuario")
            println("Bebida: $bebidaUsuario")
            println("Observação: $observacaoUsuario")

            // Mostrando na tela
            resultado.text =
                "Pedido realizado! 🍔\n\n" +
                        "Lanche: $lancheUsuario\n" +
                        "Bebida: $bebidaUsuario\n" +
                        "Observação: $observacaoUsuario"
        }
    }
}

