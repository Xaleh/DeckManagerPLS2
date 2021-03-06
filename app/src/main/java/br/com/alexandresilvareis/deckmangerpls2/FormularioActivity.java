package br.com.alexandresilvareis.deckmangerpls2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper(this);

        Intent intent = getIntent();
        Cidade cidade= (Cidade) intent.getSerializableExtra("cidade");
        if (cidade != null) {
            helper.preencheFormulario(cidade);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:

                RadioGroup corCidade = findViewById(R.id.formulario_cor);
                String cor = null;

                switch (corCidade.getCheckedRadioButtonId()){
                    case R.id.amarelo:
                        cor = "Amarelo";
                        break;

                    case R.id.azul:
                        cor = "Azul";
                        break;

                    case R.id.preto:
                        cor = "Preto";
                        break;

                    case R.id.vermelho:
                        cor = "Vermelho";
                        break;
                }

                Cidade cidade = helper.pegaCidade();
                cidade.setCor(cor);

                CityModel dao = new CityModel(this);
                if (cidade.getId() != null) {
                    dao.altera(cidade);
                    Toast.makeText(FormularioActivity.this, "Cidade " + cidade.getNome() + " alterada.", Toast.LENGTH_SHORT).show();
                } else {
                    dao.insere(cidade);
                    Toast.makeText(FormularioActivity.this, "Cidade " + cidade.getNome() + " adicionada.", Toast.LENGTH_SHORT).show();
                }
                dao.close();

                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
