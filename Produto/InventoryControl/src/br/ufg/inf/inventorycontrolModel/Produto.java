package br.ufg.inf.inventorycontrolModel;



public class Produto {
String nome, fabricante, unidadeDeMedida;
int quantidade, id;




public Produto(String nome, String fabricante, String unidadeDeMedida,
		int quantidade) {
	super();
	this.nome = nome;
	this.fabricante = fabricante;
	this.unidadeDeMedida = unidadeDeMedida;
	this.quantidade = quantidade;
}


public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getFabricante() {
	return fabricante;
}
public void setFabricante(String fabricante) {
	this.fabricante = fabricante;
}
public String getUnidadeDeMedida() {
	return unidadeDeMedida;
}
public void setUnidadeDeMedida(String unidadeDeMedida) {
	this.unidadeDeMedida = unidadeDeMedida;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

}
