package br.fiap.produto;
import br.fiap.fornecedor.Fornecedor;

public class Produto {

    private String nome;
    private int qtdEstoque;
    private double valorUnitario;
    private Fornecedor fornecedor;

    public Produto(String nome, int qtdEstoque, double valorUnitario, Fornecedor fornecedor) {
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.valorUnitario = valorUnitario;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
