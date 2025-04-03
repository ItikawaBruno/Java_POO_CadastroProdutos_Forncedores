package br.com.fiap.Model;

public class Produto {

    private String nome;
    private double valor;
    private  int quantidade;
    private Fornecedor fornecedor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public long getCnpjFornecedor(){
        return this.fornecedor.getCnpj();
    }

    public Produto(String nome, double valor, int quantidade, Fornecedor fornecedor) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }


    public double valorTotal(){
        double valorTotal=0;
        valorTotal = this.valor*this.quantidade;
        return valorTotal;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", fornecedor=" + fornecedor.getNome() +
                ", Valor Total em estoque="+valorTotal()+
                '}';
    }




    public String toStringFornecedor(){
        return "Nome: "+fornecedor.getNome()+" - CNPJ: "+fornecedor.getCnpj();
    }

}
