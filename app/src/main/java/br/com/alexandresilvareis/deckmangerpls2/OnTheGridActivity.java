package br.com.alexandresilvareis.deckmangerpls2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class OnTheGridActivity extends AppCompatActivity {

    private ListView listaCidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_the_grid);

        listaCidades = findViewById(R.id.lista_cidades);

        listaCidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cidade cidade = (Cidade) listaCidades.getItemAtPosition(position);

                Toast.makeText(OnTheGridActivity.this, "Cidade " + cidade.getNome() + " clicada.", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton novaCidade = findViewById(R.id.recycler_view_layout_fab);
        novaCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProFormulario = new Intent(OnTheGridActivity.this, FormularioActivity.class);
                startActivity(intentVaiProFormulario);
            }
        });

        FloatingActionButton epidemia = findViewById(R.id.recycler_view_layout_fab_epidemia);
        epidemia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OnTheGridActivity.this, "Epidemia começou!!", Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(listaCidades);
    }

    private void carregaLista() {
        CityModel dao = new CityModel(this);
        List<Cidade> cidades = dao.buscaCidades();
        dao.close();

        CidadesAdapter adapter = new CidadesAdapter(this, cidades);
        listaCidades.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_cidade, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_cidade:
                Intent vaiParaFormulario = new Intent(this, FormularioActivity.class);
                startActivity(vaiParaFormulario);
                break;

            case R.id.epidemia:
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Cidade cidade = (Cidade) listaCidades.getItemAtPosition(info.position);
    }
}
