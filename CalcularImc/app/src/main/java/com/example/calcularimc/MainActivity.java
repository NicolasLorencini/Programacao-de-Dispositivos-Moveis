package com.example.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edAltura;
    private EditText edPeso;
    private Button btHomem;
    private Button btMulher;
    private TextView tvResultado;
    private Button btLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edAltura = findViewById(R.id.edAltura);
        edPeso = findViewById(R.id.edPeso);
        btHomem = findViewById(R.id.btHomem);
        btMulher = findViewById(R.id.btMulher);
        tvResultado = findViewById(R.id.tvResultado);
        btLimpar = findViewById(R.id.btLimpar);
    }
}