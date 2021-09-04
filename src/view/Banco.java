package view;

import java.util.ArrayList;
import java.util.Scanner;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Banco {
	
	static String nome = "Bank";
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Conta> contas;
	
	
	public static void main(String[] args) {
		contas = new ArrayList<Conta>();
		menu();
	}
	
	/**
	 * Menu inicial do Sistema, apresentando todas as opções e chamando as funções conforme a opção
	 * solicitada pelo usuario
	 */
	public static void menu() {
		int opcao = 0;
		System.out.println("==============================");
		System.out.println("=============ATM==============");
		System.out.println("=========" + Banco.nome + "==========");
		System.out.println("==============================");
		
		System.out.println("Selecione uma das opções abaixo");
		
		System.out.println("1-Criar Conta");
		System.out.println("2-Efetuar Saque");
		System.out.println("3-Efetuar Deposito");
		System.out.println("4-Efetuar Transferencia");
		System.out.println("5-Listar Contas");
		System.out.println("6-Sair");
		
		try {
			opcao = Integer.parseInt(teclado.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Por favor, informe uma opção valida");
			Utils.pausar(2);
			menu();
		}
		
		switch (opcao) {
		case 1:	
			criar_conta();
			break;
		case 2:
			efetuar_saque();
			break;
		case 3:
			efetuar_deposito();
			break;
		case 4:
			efetuar_transferencia();
			break;
		case 5:
			listar_conta();
			break;
		case 6:
			System.out.println("Volte Sempre!");
			Utils.pausar(2);
			System.exit(0);
		default:
			System.out.println("Opção Invalida");
			Utils.pausar(2);
			menu();
			break;
		}
	}
	
	/**
	 * Função para realizar a criação de uma conta, recebe todos os dados e instancia um objeto
	 * da classe Conta
	 */
	public static void criar_conta() {
		System.out.println("Digite os dados do cliente: ");
		
		System.out.println("Nome do cliente: ");
		String nome = teclado.nextLine();
		System.out.println("Email do cliente: ");
		String email = teclado.nextLine();
		System.out.println("CPF do cliente: ");
		String cpf = teclado.nextLine();
		System.out.println("Data de nascimento do cliente: ");
		String data_nascimento = teclado.nextLine();
		
		Cliente cliente = new Cliente(nome, email, cpf, Utils.string_data(data_nascimento));
		Conta conta = new Conta(cliente);
		contas.add(conta);
		System.out.println("Conta criada com sucesso");
		System.out.println("Dados da conta criada: ");
		System.out.println(conta);
		System.out.println();
		Utils.pausar(2);
		menu();
	}
	
	/**
	 * Função para efetuar um saque, recebe o numero da conta, verifica se existe, e caso exista
	 * solicita o valor e subtrai do saldo da conta
	 */
	public static void efetuar_saque() {
		System.out.println("Digite o numero da conta: ");
		int numero = teclado.nextInt();
		Conta conta = buscar_conta(numero);
		
		if (conta != null) {
			System.out.println("Digite o valor do saque: ");
			Double valor = teclado.nextDouble();
			conta.sacar(valor);
		}else {
			System.out.println("Não foi encontrada a conta com o numero " + numero);
		}
		Utils.pausar(3);
		menu();
	}
	
	/**
	 * Função para efetuar um deposito, recebe o numero da conta, verifica se existe, e caso exista
	 * solicita o valor e adiciona ao saldo da conta
	 */
	public static void efetuar_deposito() {
		System.out.println("Digite o numero da conta: ");
		int numero = teclado.nextInt();
		Conta conta = buscar_conta(numero);
		
		if (conta != null) {
			System.out.println("Digite o valor do deposito: ");
			Double valor = teclado.nextDouble();
			conta.depositar(valor);
		}else {
			System.out.println("Não foi encontrada a conta com o numero " + numero);
		}
		Utils.pausar(3);
		menu();
	}
	
	/**
	 * Função para efetuar uma transferencia entre duas contas, recebe o numero das duas contas, 
	 * e caso existam, realiza a transferencia
	 */
	public static void efetuar_transferencia() {
		System.out.println("Digite o numero da conta: ");
		int numero_origem = teclado.nextInt();
		Conta conta_origem = buscar_conta(numero_origem);
		
		if(conta_origem != null) {
			System.out.println("Digite o numero da conta destino: ");
			int numero_destino = teclado.nextInt();
			Conta conta_destino = buscar_conta(numero_destino);
			if(conta_destino != null) {
				System.out.println("Digite o valor da transferencia: ");
				Double valor = teclado.nextDouble();
				conta_origem.transferir(conta_destino, valor);
				System.out.println("Transferencia realizada com sucesso");
			}else {
				System.out.println("Não foi encontrada a conta destino com o numero " + numero_destino);
			}
		}else {
			System.out.println("Não foi encontrada a conta com o numero " + numero_origem);
		}
		Utils.pausar(3);
		menu();
		
	}
	
	public static void listar_conta() {
		if(contas.size() > 0) {
			System.out.println("Listando contas");
			System.out.println();
			
			for(Conta conta : contas) {
				System.out.println(conta);
				System.out.println();
				Utils.pausar(1);
			}
			System.out.println();
		}else {
			System.out.println("Não existem contas cadastradas");
		}
		Utils.pausar(3);
		menu();
	}
	
	private static Conta buscar_conta(int num) {
		Conta c = null;
		if(contas.size() > 0) {
			for(Conta conta: contas) {
				if(conta.getNumero() == num) {
					c = conta;
				}
			}
		}
		return c;
	}

}
