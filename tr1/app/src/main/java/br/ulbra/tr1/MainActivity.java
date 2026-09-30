package br.ulbra.tr1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        TextInputEditText lanche = findViewById(R.id.etxtLanche);
        TextInputEditText bebida = findViewById(R.id.etxtBebida);
        TextInputEditText observacao = findViewById(R.id.etxtObservacao);

        Button botao = findViewById(R.id.btn_Pedir);

        TextView resultado = findViewById(R.id.txtResultado);

        botao.setOnClickListener(view -> {

            String nomeLanche = lanche.getText().toString().trim();
            String nomeBebida = bebida.getText().toString().trim();
            String textoObservacao = observacao.getText().toString().trim();

            System.out.println("Lanche: " + nomeLanche);
            System.out.println("Bebida: " + nomeBebida);
            System.out.println("Observação: " + textoObservacao);

            resultado.setText(
                    "Pedido: " +
                            nomeLanche +
                            " + " +
                            nomeBebida +
                            " (" +
                            textoObservacao +
                            ")"
            );
        });
    }
}