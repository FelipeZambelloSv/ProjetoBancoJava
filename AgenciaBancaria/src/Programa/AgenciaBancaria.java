package Programa;

import java.util.Scanner;
import java.util.ArrayList;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String [] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("=================================");
		System.out.println("==Bem vindos ao banco Zambllo's==");
		System.out.println("==================================");
		System.out.println("Selecione a operação que desejada:");
		System.out.println("==================================");
		System.out.println("*_____Opção 1 - Criar conta____*");
		System.out.println("*_____Opção 2 - Depositar______*");
		System.out.println("*_____Opção 3 - Sacar__________*");
		System.out.println("*_____Opção 4 - Transferir_____*");
		System.out.println("*_____Opção 5 - Listar_________*");
		System.out.println("*_____Opção 6 - Sair___________*");
	
		int operacao = input.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Obrigado por usar nosso banco");
			System.exit(0);
			
		default:
			System.out.println("Opção Inválida!");
			operacoes();
			break;	
		}
	}

	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = input.next();
		
		System.out.println("\nCPF: ");
		String cpf = input.next();
		
		System.out.println("\nmail: ");
		String email = input.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		System.out.println("Conta criada com sucesso!");
		
		operacoes();
	}	

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta); {
				conta = c;
			} 
		}
	}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!");
		}else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
		}else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	}	
	
	public static void transferir() {
		System.out.println("Número conta do remetente: ");
		int numeroContaRemetente = input.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null); {
			System.out.println("Número da conta do destinatário: ");
			int numeroContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Valor da transferência: ");
				Double valor = input.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}else {
				System.out.println("Conta para tranferência não encontrada");
			}
		}
		operacoes();
	}
	
	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não há contas cadastradas");
		}
		operacoes();
	}
}
