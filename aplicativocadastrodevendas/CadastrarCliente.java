package com.example.aplicativocadastrodevendas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativocadastrodevendas.modelo.Cliente;

public class CadastrarCliente extends AppCompatActivity {

    private EditText edNome;
    private EditText edCpf;
    private Button btCadastrar;
    private Button btRetornar;
    private TextView tvClientesCadastrados;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

        edNome = findViewById(R.id.edNome);
        edCpf = findViewById(R.id.edCpf);
        btCadastrar = findViewById(R.id.btCadastrar);
        btRetornar = findViewById(R.id.btRetornar);
        tvClientesCadastrados = findViewById(R.id.tvClientesCadastrados);

        atualizarListaClientes();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edNome.getText().toString().isEmpty()){
                    edNome.setError("Erro!");
                }

                if (edCpf.getText().toString().isEmpty()|| edCpf.getText().toString().equals("0")){
                    edCpf.setError("Erro! selecione um número válido");
                }

                String nome = edNome.getText().toString();
                String cpf = edCpf.getText().toString();


                String mensagem = "  Nome: " + nome +  " CPF: " + cpf;
                Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();

                Cliente cliente = new Cliente();
                cliente.setCpf(edCpf.getText().toString());
                cliente.setNome(edNome.getText().toString());

                Controller.getInstance().salvarCliente(cliente);

                Toast.makeText(CadastrarCliente.this,
                        "O nome foi cadastrado com sucesso!!!!",
                        Toast.LENGTH_LONG).show();

                try {
                    this.finalize();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }

        });

        btRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        }

    private void atualizarListaClientes () {


        String texto = tvClientesCadastrados.getText().toString();

        for (Cliente cliente: Controller.getInstance().retornarCliente()) {
            texto += "Nome: " + cliente.getNome() + "CPF: " + cliente.getCpf() + "\n";
        }
        tvClientesCadastrados.setText(texto);


    }

}