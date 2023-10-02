package com.example.aplicativocadastrodevendas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativocadastrodevendas.modelo.Cliente;
import com.example.aplicativocadastrodevendas.modelo.Item;

public class CadastrarItem extends AppCompatActivity {
    private EditText edCodItem;
    private EditText edValorUnitario;
    private EditText edDescricaoItem;
    private Button btRetornar;
    private Button btSalvar;
    private TextView tvItensCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_item);

        btSalvar = findViewById(R.id.btCadastrar);
        edCodItem = findViewById(R.id.edCodItem);
        edValorUnitario = findViewById(R.id.edValorUnitario);
        edDescricaoItem = findViewById(R.id.edDescItem);
        btRetornar = findViewById(R.id.btRetornar);
        tvItensCadastrados = findViewById(R.id.tvItensCadastrados);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edValorUnitario.getText().toString().isEmpty()|| edValorUnitario.getText().toString().equals("0")){
                    edValorUnitario.setError("Erro! Selexione um número válido");
                }

                if (edDescricaoItem.getText().toString().isEmpty()){
                    edValorUnitario.setError("Erro!");
                }

                if (edCodItem.getText().toString().isEmpty()|| edValorUnitario.getText().toString().equals("0")){
                    edValorUnitario.setError("Erro! Selexione um número válido");
                }

                String codItem = edCodItem.getText().toString();
                String valorUnitario = edValorUnitario.getText().toString();
                String descricaoItem = edDescricaoItem.getText().toString();




                atualizarListaItens(codItem, valorUnitario, descricaoItem);

                Item item = new Item();
                item.setCodigoItem(Integer.valueOf(edCodItem.getText().toString()));
                item.setDescricao(edDescricaoItem.getText().toString());
                item.setValorUnitario(Double.parseDouble(edValorUnitario.getText().toString()));

                Controller.getInstance().salvarItem(item);

                Toast.makeText(CadastrarItem.this,
                        "O item foi cadastrado com sucesso!!!!",
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
    private void atualizarListaItens(String codItem, String valorUntario, String descricaoItem){

        String texto = tvItensCadastrados.getText().toString();

        for (Item item : Controller.getInstance().retornarItem()){
            texto += "Código do Item " + item.getCodigoItem() + "Desecrição do item "
                    + item.getDescricao() +"Valor único do item " + item.getValorUnitario() + "\n";
            }
        tvItensCadastrados.setText(texto);
        }
    }
