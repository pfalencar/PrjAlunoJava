package model;

public class Aluno {
	
	private int id;
	private String nome;
	private String endereco;
	private String bairro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void imprimirAluno() {
		System.out.println("Id: " + this.id + ", Nome: " + this.nome + ", Endereço: " 
	          + this.endereco + ", Bairro: " + this.bairro);
	}
	

}
