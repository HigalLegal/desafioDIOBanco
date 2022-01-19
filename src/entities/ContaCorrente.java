package entities;

import entities.exception.DinheiroInsuficienteException;

public class ContaCorrente extends Conta {
	
	public final double TAXA = 0.05;

	public ContaCorrente(String nomeBanco, int agencia, int numero, Cliente cliente) {
		super(nomeBanco, agencia, numero, cliente);
	}

	public ContaCorrente(String nomeBanco, int agencia, int numero, double saldo, Cliente cliente) {
		super(nomeBanco, agencia, numero, saldo, cliente);
	}
	
	//-----------------------------------------------
	
	@Override
	public void depositar(double valor) {
		super.saldo += valor - (valor * TAXA);
		
	}

	@Override
	public void sacar(double valor) {
		if(valor > super.saldo) {
			throw new DinheiroInsuficienteException("Sem dinheiro para este saque.");
		} else {
			super.saldo -= valor;
		}
	}

	@Override
	public void transferir(Conta contaDestino, double valor) {
		if(valor > super.saldo) {
			throw new DinheiroInsuficienteException("Sem dinheiro para esta transferência.");
		} else {
			super.saldo -= valor;
			contaDestino.depositar(valor - (valor * TAXA));
		}
		
	}
	
	//-----------------------------------------------
	
	@Override
	public String toString() {
		return "Titular: " + cliente.getNome() + " || " + "Saldo: " + saldo + " || " + "Banco: " + nomeBanco + " || Conta Corrente.";
	}

}
