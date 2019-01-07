package br.com.alexandresilvareis.deckmangerpls2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class CidadesAdapter extends BaseAdapter {
    private final List<Cidade> cidades;
    private final Context context;

    public CidadesAdapter(Context context, List<Cidade> cidades) {
        this.context = context;
        this.cidades = cidades;
    }

    @Override
    public int getCount() {
        return cidades.size();
    }

    @Override
    public Object getItem(int position) {
        return cidades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return cidades.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cidade cidade = cidades.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.main_card_view, parent, false);
        }

        TextView campoNome = view.findViewById(R.id.main_card_title);
        campoNome.setText(cidade.getNome());

        TextView campoChance = view.findViewById(R.id.main_card_percent);
        campoChance.setText(cidade.getChance_de_sair());

        TextView campoQuantidade = view.findViewById(R.id.main_card_quantidade);
        campoQuantidade.setText(cidade.getQuantidade());

        RelativeLayout colorBar = view.findViewById(R.id.color_bar);
        switch (cidade.getCor()) {

            case "Amarelo":
                colorBar.setBackgroundColor(Color.parseColor("@colors/colorCityYellow"));
                break;

            case "Azul":
                colorBar.setBackgroundColor(Color.parseColor("@colors/colorCityBlue"));
                break;

            case "Preto":
                colorBar.setBackgroundColor(Color.parseColor("@colors/colorCityBlack"));
                break;

            case "Vermelho":
                colorBar.setBackgroundColor(Color.parseColor("@colors/colorCityRed"));
                break;
        }

        return view;
    }
}
