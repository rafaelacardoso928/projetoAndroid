package br.ulbra.produto

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

        val produto = findViewById<TextInputEditText>(R.id.etxtProduto)
        val preco = findViewById<TextInputEditText>(R.id.etxtPreco)
        val quantidade = findViewById<TextInputEditText>(R.id.etxtQuantidade)

        val botao = findViewById<Button>(R.id.btn_Cadastrar)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        botao.setOnClickListener {

            val produtoUsuario = produto.text.toString()
            val precoUsuario = preco.text.toString().toDouble()
            val quantidadeUsuario = quantidade.text.toString().toInt()

            println("Produto: $produtoUsuario")
            println("Preço: R$ $precoUsuario")
            println("Quantidade: $quantidadeUsuario")

            if (precoUsuario <= 0) {

                println("Preço inválido!")

                resultado.text =
                    "⚠️ Preço inválido!\n\nO preço deve ser maior que R$ 0,00."

            } else {

                val valorEstoque = precoUsuario * quantidadeUsuario

                println("Produto cadastrado!")

                resultado.text =
                    "✓ Produto cadastrado!\n\n" +
                            "$produtoUsuario cadastrado!\n" +
                            "Valor em estoque: R$ $valorEstoque"
            }
        }
    }
}