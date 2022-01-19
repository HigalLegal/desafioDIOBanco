package factory;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class ContaFactory {

	public static Conta contaFactory(char tipoDeConta, String nomeBanco, int agencia, int numero, double saldo, Cliente cliente) {
		if(tipoDeConta == 'c' || tipoDeConta == 'C') {
			return new ContaCorrente(nomeBanco, agencia, numero, saldo, cliente);
		} else if(tipoDeConta == 'p' || tipoDeConta == 'P') {
			return new ContaPoupanca(nomeBanco, agencia, numero, saldo, cliente);
		}
		
		return null;
	}
	
	public static Conta contaFactory(char tipoDeConta, String nomeBanco, int agencia, int numero, Cliente cliente) {
		if(tipoDeConta == 'c' || tipoDeConta == 'C') {
			return new ContaCorrente(nomeBanco, agencia, numero, cliente);
		} else if(tipoDeConta == 'p' || tipoDeConta == 'P') {
			return new ContaPoupanca(nomeBanco, agencia, numero, cliente);
		}
		
		return null;
	}
}
