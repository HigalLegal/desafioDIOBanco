package entities;

import entities.exception.MenorDeIdadeException;

public class Cliente {

	private String nome;
	private String cpfouCNPJ;
	private int idade;
	
	//------------------------------------
	
	public Cliente() {}
	
	public Cliente(String nome, String cpfouCNPJ, int idade) {
		this.nome = nome;
		this.cpfouCNPJ = cpfouCNPJ;
		this.idade = idade;
		
		if(idade < 18) {
			throw new MenorDeIdadeException("Você precisa ter ao menos 18 anos.");
		}
		
	}
	
	//------------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPFouCNPJ() {
		return cpfouCNPJ;
	}

	public void setCPFouCNPJ(String cpfouCNPJ) {
		this.cpfouCNPJ = cpfouCNPJ;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
}
