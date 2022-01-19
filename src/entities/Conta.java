package entities;

public abstract class Conta {
	
	protected String nomeBanco;
	protected int agencia;
	protected int numero;
	protected double saldo;
	
	protected Cliente cliente;
	
	//------------------------------------

	public Conta(String nomeBanco, int agencia, int numero, double saldo, Cliente cliente) {
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public Conta(String nomeBanco, int agencia, int numero, Cliente cliente) {
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
	}
	
	//------------------------------------

	public String getNomeBanco() {
		return nomeBanco;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	//------------------------------------
	
	public abstract void sacar(double valor);
	
	public abstract void depositar(double valor);
	
	public abstract void transferir(Conta contaDestino, double valor);
	
	
}
