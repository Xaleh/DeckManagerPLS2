package br.com.alexandresilvareis.deckmangerpls2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class OnTheGridActivity extends AppCompatActivity {

    private ListView listaCidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_the_grid);

        Button novaCidade = findViewById(R.id.recycler_view_layout_fab);
        novaCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProFormulario = new Intent(OnTheGridActivity.this, FormularioActivity.class);
                startActivity(intentVaiProFormulario);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }


}
