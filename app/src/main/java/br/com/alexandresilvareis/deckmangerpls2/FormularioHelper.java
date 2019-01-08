package br.com.alexandresilvareis.deckmangerpls2;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoQuantidade;

    private RadioButton campoAmarelo;
    private RadioButton campoAzul;
    private RadioButton campoPreto;
    private RadioButton campoVermelho;

    private Cidade cidade;

    public FormularioHelper(FormularioActivity activity) {
        campoNome = activity.findViewById(R.id.formulario_nome);
        campoQuantidade = activity.findViewById(R.id.formulario_quantidade);
        cidade = new Cidade();
    }

    public Cidade pegaCidade() {
        cidade.setNome(campoNome.getText().toString());
        cidade.setQuantidade(Integer.valueOf(campoQuantidade.getText().toString()));
        cidade.setTotal_cidades(somaNumeroCidades());
        /*cidade.setCor(FormularioActivity.pegaCor());*/
        cidade.setChance_de_sair(calculaChance());
        return cidade;
    }

    private Integer somaNumeroCidades() {
        Integer total;
        Integer totalCidades;
        totalCidades = cidade.getTotal_cidades();
        if (totalCidades == null) {
            totalCidades = 0;
        }
        total = totalCidades + cidade.getQuantidade();
        return total;
    }

    private Integer calculaChance() {
        Integer chance;
        chance = (cidade.getQuantidade()/cidade.getTotal_cidades()) * 100;
        return chance;
    }

    public void preencheFormulario (Cidade cidade) {
        campoNome.setText(cidade.getNome());
        campoQuantidade.setText(cidade.getQuantidade());
        carregaCor(cidade.getCor());
        this.cidade = cidade;
    }

    private void carregaCor(String cor) {
        switch (cor) {
            case "Amarelo":
                campoAmarelo.setChecked(true);
                break;

            case "Azul":
                campoAzul.setChecked(true);
                break;

            case "Preto":
                campoPreto.setChecked(true);
                break;

            case "Vermelho":
                campoVermelho.setChecked(true);
                break;
        }
    }

}
