package br.com.fiap.Principal;

import br.com.fiap.Model.Fornecedor;
import br.com.fiap.Model.Produto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Principal {

    Scanner e = new Scanner(System.in);
    List<Produto> listaProdutos = new ArrayList<>();
    private Fornecedor fornecedor;
    private Produto produto;

    public void menu(){
        int opcao = 0;
        String menu = "1. Cadastrar Produto\n2.Pesquisa produto por nome\n3. pesquisa fonecedor por CNPJ\n4. Listar Produtos\n5. Filtrar produtos por preco\n6. Finalizar";
        while (true){
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            if(opcao == 1){
                cadastroProdutos();
            } else if (opcao == 2) {
                pesquisarProduto();
            } else if (opcao == 3 ) {
                pesquisaFonecedor();
            } else if (opcao == 4) {
                listarProdutos();
            } else if (opcao == 5) {
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor minimo que deseja filtrar"));
                filtrarPorPreco(valor);
            } else if (opcao == 6) {
                return;
            }

        }
    }


    public Fornecedor isFornecedor(){
        long cnpj = Long.parseLong(JOptionPane.showInputDialog("CNPJ do fornecedor"));

        for (Produto produto : listaProdutos){
            if ((produto.getCnpjFornecedor() == cnpj)){
                return fornecedor;
            }
        }
         JOptionPane.showMessageDialog(null,"Fornecedor não encontrado");
        return  null;
    }



    private void cadastroProdutos(){
        Fornecedor fornecedor = isFornecedor();
        if(fornecedor == null) {
            String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto: "));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
            fornecedor = cadastroFornecedor();
            Produto produto = new Produto(nome, valor, quantidade, fornecedor);
            listaProdutos.add(produto);
        }else {
            String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto: "));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
            Produto produto = new Produto(nome, valor, quantidade, fornecedor);
            listaProdutos.add(produto);
        }
    }

    private Fornecedor cadastroFornecedor(){
        String nome = JOptionPane.showInputDialog("Digite o nome do fornecedor: ");
        long cnpj = Long.parseLong(JOptionPane.showInputDialog("Digite o CNPJ do fornecedor: "));
        Fornecedor fornecedor = new Fornecedor(nome, cnpj);
        return  fornecedor;
    }


    private void pesquisarProduto() {
        String aux = "Produto não encontrado";
        String nome = JOptionPane.showInputDialog("Digite o nome do produto que deseja pesquisar: ").toLowerCase();
        for (Produto produto : listaProdutos){
            if (produto.getNome().toLowerCase().contains(nome)){
                aux=produto.toString();
            }
        }
        JOptionPane.showMessageDialog(null,aux);
    }

    private void pesquisaFonecedor() {
        long cnpj = Long.parseLong(JOptionPane.showInputDialog("Digite o CNPJ do fornecedor: "));
        for(Produto produto : listaProdutos){
            if (produto.getCnpjFornecedor() == cnpj){
                JOptionPane.showMessageDialog(null,produto.toStringFornecedor());
            }
        }
    }

    public void filtrarPorPreco(double preco){
        listaProdutos.stream().filter(f -> f.getValor() > preco).forEach(f -> JOptionPane.showMessageDialog(null,f.toString()));
    }


    private void listarProdutos() {
        listaProdutos.forEach(p -> JOptionPane.showMessageDialog(null,p.toString()));
    }

}
