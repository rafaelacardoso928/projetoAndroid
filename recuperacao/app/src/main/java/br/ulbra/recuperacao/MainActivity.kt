package br.ulbra.recuperacao

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

        val email = findViewById<TextInputEditText>(R.id.etxtEmail)
        val confirmarEmail =
            findViewById<TextInputEditText>(R.id.etxtConfirmarEmail)

        val botao = findViewById<Button>(R.id.btn_Recuperar)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        botao.setOnClickListener {

            val emailUsuario = email.text.toString()
            val confirmarEmailUsuario =
                confirmarEmail.text.toString()

            println("E-mail: $emailUsuario")
            println("Confirmação: $confirmarEmailUsuario")

            if (emailUsuario != confirmarEmailUsuario) {

                println("Os e-mails não conferem!")

                resultado.text =
                    "⚠️ Os e-mails não conferem!\n\n" +
                            "Digite o mesmo e-mail nos dois campos."

            } else {

                println("Link enviado para $emailUsuario")

                resultado.text =
                    "✓ Link enviado!\n\n" +
                            "Enviamos o link de recuperação para:\n" +
                            "$emailUsuario"
            }
        }
    }
}