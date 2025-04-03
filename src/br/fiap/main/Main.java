package br.fiap.main;

import br.fiap.fornecedor.Fornecedor;

public class Main {
    public static void main(String[] args) {

        Fornecedor fornecedor = new Fornecedor("xpto", 1);

        System.out.println(fornecedor.getNome());
        fornecedor.setNome("fiap");
        System.out.println(fornecedor.getNome());
    }
}
