package com.example.serie;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etN;
    Button btnGenerar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etN = findViewById(R.id.etN);
        btnGenerar = findViewById(R.id.btnGenerar);
        tvResultado = findViewById(R.id.tvResultado);

        btnGenerar.setOnClickListener(v -> {

            String texto = etN.getText().toString();

            if (texto.isEmpty()) {
                tvResultado.setText("Error: campo vacío");
                return;
            }

            int n;

            try {
                n = Integer.parseInt(texto);
            } catch (Exception e) {
                tvResultado.setText("Error: valor no numérico");
                return;
            }

            if (n <= 0) {
                tvResultado.setText("Error: n debe ser mayor a 0");
                return;
            }

            String resultado = generarSerie(n);
            tvResultado.setText(resultado);
        });
    }

    public String generarSerie(int n) {
        StringBuilder resultado = new StringBuilder();
        double valor = 1;
        double incremento = 1.5;
        double suma = 0;

        for (int i = 1; i <= n; i++) {

            double termino;

            if (i == 1) {
                termino = valor;
            } else {
                valor = valor + incremento;
                incremento += 1;
                termino = valor;
            }

            // Alternar signo
            if (i % 2 == 0) {
                termino *= -1;
            }

            suma += termino;

            resultado.append(termino);

            if (i < n) {
                resultado.append(", ");
            }
        }

        resultado.append("\nSuma: ").append(suma);

        return resultado.toString();
    }
}