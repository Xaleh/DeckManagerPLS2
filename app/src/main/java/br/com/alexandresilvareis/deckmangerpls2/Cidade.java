package br.com.alexandresilvareis.deckmangerpls2;

import java.io.Serializable;

public class Cidade implements Serializable {

    private Long id;
    private String nome;
    private String cor;
    private Integer quantidade;
    private Integer chance_de_sair;
    private Integer total_cidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() { return cor; }

    public void setCor(String cor) { this.cor = cor; }

    public Integer getQuantidade() { return quantidade; }

    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Integer getChance_de_sair() { return chance_de_sair; }

    public void setChance_de_sair(Integer chance_de_sair) { this.chance_de_sair = chance_de_sair; }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }

    public Integer getTotal_cidades() { return total_cidades; }

    public void setTotal_cidades(Integer total_cidades) {
        this.total_cidades = total_cidades;
    }
}
