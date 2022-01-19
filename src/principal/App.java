package principal;

import java.util.Scanner;

import entities.Cliente;
import entities.Conta;
import entities.exception.DinheiroInsuficienteException;
import entities.exception.MenorDeIdadeException;
import factory.ContaFactory;

public class App {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Primeiramente, digite os seus dados.");
			
			System.out.print("Nome completo: ");
			String nome = scan.nextLine();
			System.out.print("CPF ou CNPJ: ");
			String cpfOuCNPJ = scan.next();
			System.out.print("Digite sua idade: ");
			int idade = scan.nextInt();
			
			Cliente cliente = new Cliente(nome, cpfOuCNPJ, idade);
			
			System.out.println("\nDados banc�rios.");
			System.out.print("Digite 'C' caso for conta corrente, e 'P' caso for conta poupan�a: ");
			char tipoDeConta = scan.next().charAt(0);
			System.out.print("Digite o nome do banco: ");
			String nomeBanco = scan.nextLine();
			scan.nextLine();
			System.out.print("N�mero da ag�ncia: ");
			int agencia = scan.nextInt();
			System.out.print("N�mero do banco: ");
			int numero = scan.nextInt();
			
			Conta conta = ContaFactory.contaFactory(tipoDeConta, nomeBanco, agencia, numero, cliente);
			
			System.out.println("Gostaria de fazer um dep�sito inicial? S/N");
			char resposta = scan.next().charAt(0);
			
			if(resposta == 'S' || resposta == 's') {
				System.out.print("Digite o valor do dep�sito inicial: ");
				double depositoInicial = scan.nextDouble();
				conta = ContaFactory.contaFactory(tipoDeConta, nomeBanco, agencia, numero, depositoInicial, cliente);
			}
			
			System.out.println(conta);
			
			System.out.print("\nDigite o valor do deposito: ");
			double valor = scan.nextDouble();
			conta.depositar(valor);
			
			System.out.println(conta);
			
			System.out.print("\nDigite o valor do saque: ");
			valor = scan.nextDouble();
			conta.sacar(valor);
			
			System.out.println(conta);
			
			System.out.print("\nDigite o valor da transfer�ncia: ");
			valor = scan.nextDouble();
			
			Cliente cliente2 = new Cliente("�talo", "44488811100", 20);
			Conta conta2 = ContaFactory.contaFactory('C', "Inter", 13, 80, 20.0, cliente2);
			
			System.out.println("Conta 2 antes da transfer�ncia:");
			System.out.println(conta2);
			
			conta.transferir(conta2, valor);
			
			System.out.println("\nConta 2 ap�s a transfer�ncia:");
			System.out.println(conta2);
			
			System.out.println("\nSua conta ap�s a transfer�ncia: ");
			System.out.println(conta);
			
		} catch(DinheiroInsuficienteException e) {
			System.out.println(e.getMessage());
		} catch(MenorDeIdadeException e) {
			System.out.println(e.getMessage());
		} finally {
			scan.close();
		}
	}
}
/*
 * Uma observa��o: Coloquei os valores da conta 2 j� definidos sem usor do Scanner
 * porque se n�o o c�digo ia ficar mais grande, e consequentemente, menos leg�vel.
 * */























