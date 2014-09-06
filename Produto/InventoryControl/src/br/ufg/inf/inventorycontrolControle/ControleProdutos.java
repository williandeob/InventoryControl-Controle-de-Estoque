package br.ufg.inf.inventorycontrolControle;

import java.util.ArrayList;

import br.ufg.inf.inventorycontrolModel.Produto;

public class ControleProdutos {
public static ArrayList<Produto> produtosCadastrados=new ArrayList<Produto>();

	public ControleProdutos() {
	}
	
	
	public void cadastraProduto(String nome, String fabricante, String unidadeDeMedida, int quantidade){
		Produto novoProduto;
		novoProduto = new Produto(nome,fabricante,unidadeDeMedida,quantidade);
		produtosCadastrados.add(novoProduto);
		
	}
	
	public void alterarProduto(int posicao,String nome, String fabricante, String unidadeDeMedida, int quantidade){
		produtosCadastrados.get(posicao).setNome(nome);
		produtosCadastrados.get(posicao).setFabricante(fabricante);
		produtosCadastrados.get(posicao).setUnidadeDeMedida(unidadeDeMedida);
		produtosCadastrados.get(posicao).setQuantidade(quantidade);;
		
	}

}
