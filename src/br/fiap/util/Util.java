package br.fiap.util;
import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import javax.swing.*;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class Util {
    private Produto[] produto = new Produto[2];
    private Fornecedor[] fornecedor = new Fornecedor[2];
    private int idxProduto = 0;
    private int idxFornecedor = 0;

    public void menu() {
        int opcao=0;
        String msg = "1. Cadastrar Produto\n2. Pesquisar Produto\n3. Pesquisar Fornecedor\n4. Finalizar";

        while(true) {
            opcao = parseInt(showInputDialog(msg));
            if (opcao == 4) {
                return;
            }

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                            break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisar();
                    break;
                default:
                    showInputDialog(null, "Opção Inválida");
            }
        }
    }

    private void pesquisar() {
        String aux = "";
        Fornecedor fornecedor = pesquisarFornecedor();
        if(fornecedor != null) {
            aux += "Fornecedor: " + fornecedor.getNome() + "\n";
            aux += "CNPJ: " + fornecedor.getCnpj() + "\n";
            showMessageDialog(null, aux);
        }
    }

    private void cadastrarProduto() {
        String nome;
        int qtdEstoque;
        double valorUnitario;
        Fornecedor fornecedor = pesquisarFornecedor();
        if(fornecedor == null) {
            fornecedor = cadastrarFornecedor();
        }
        nome = showInputDialog("Nome do Produto");
        qtdEstoque = parseInt(showInputDialog("Quantidade em Estoque"));
        valorUnitario = parseDouble(showInputDialog("Valor Unitário"));
        produto[idxProduto] = new Produto(nome, qtdEstoque, valorUnitario, fornecedor);
        idxProduto++;
    }

    private Fornecedor cadastrarFornecedor() {
        long cnpj = parseLong(showInputDialog("CNPJ do Fornecedor"));
        String nome = showInputDialog("Nome");
        fornecedor[idxFornecedor] = new Fornecedor(nome, cnpj);
        idxFornecedor++;
        return fornecedor[idxFornecedor-1];
    }

    private void pesquisarProduto() {
        String aux = "Produto não Encontrado";
        String nome = showInputDialog("Nome do Produto");
        for (int i = 0; i < idxProduto; i++) {
            if(produto[i].getNome().equalsIgnoreCase(nome)) {
                aux = "";
                aux += "Nome do Produto: " + nome + "\n";
                aux += "Valor Unitário: R$" + produto[i].getValorUnitario() + "\n";
                aux += "Valor Unitário: R$" + produto[i].getFornecedor().getNome() + "\n";
            }
        }
        showMessageDialog(null, aux);
    }

    private Fornecedor pesquisarFornecedor() {
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i < idxFornecedor; i++) {
            if (fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, "CNPJ não Cadastrado");
        return null;
    }
}
