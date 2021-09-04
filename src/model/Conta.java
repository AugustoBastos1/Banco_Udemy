package model;

import helper.Utils;

/**
Metodo construtor da classe Conta
*/
public class Conta {
	private static int contador = 1001;
	private int numero;
	private Cliente cliente;
	private Double saldo = 0.0;
	private Double limite = 0.0;
	private Double saldo_total;
	
	
	public Conta(Cliente cliente) {
		this.numero = contador;
		this.cliente = cliente;
		contador++;
		this.atualiza_saldo_total();
	}
	
	/*
	Getters e Setters
	*/
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Double getLimite() {
		return limite;
	}
	
	public void setLimite(Double limite) {
		this.limite = limite;
		this.atualiza_saldo_total();
	}
	
	public int getNumero() {
		return numero;
	}
	
	public Double getSaldo_total() {
		return saldo_total;
	}
	
	private void atualiza_saldo_total() {
		this.saldo_total = this.getSaldo() + this.getLimite();
	}
	
	
	/**
	 Sobrecarga do metodo "To String" da classe Conta
	 */
	public String toString() {
		return "Numero da conta: " + this.getNumero() + "\nCliente: " + this.cliente.getNome() +
				"\nSaldo Total: " + Utils.double_string(this.getSaldo_total());
	}
	
	/**
	 Metodo para depositar um valor dentro de uma conta
	 */
	public void depositar(Double valor) {
		if (valor > 0) {
			this.saldo = this.getSaldo() + valor;
			this.atualiza_saldo_total();
			System.out.println("Deposito efetuado com sucesso");
		}else {
			System.out.println("Erro ao efetuar deposito tente novamente");
		}
	}
	
	/**
	 Metodo para realizar um saque, caso seja possivel, subtrai o valor solicitado
	 */
	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo_total() >= valor) {
			if(this.getSaldo() > valor) {
				this.saldo = this.getSaldo() - valor;
				this.atualiza_saldo_total();
				System.out.println("Saque realizado com sucesso");
			}else {
				Double restante = this.getSaldo() - valor;
				this.limite = this.getLimite() + restante;
				this.saldo = 0.0;
				this.atualiza_saldo_total();
				System.out.println("Saque realizado com sucesso");
			}
		}else {
			System.out.println("Saque não realizado tente novamente");
		}
	}
	
	/**
	 Metodo para realizar uma transferencia, caso seja possivel, coloca o valor na conta destino
	 e subtrai da conta de origem
	 */
	public void transferir(Conta destino, Double valor) {
		if (valor > 0 && this.getSaldo_total() >= valor) {
			if(this.getSaldo() > valor) {
				this.saldo = this.getSaldo() - valor;
				destino.saldo = destino.getSaldo() + valor;
				this.atualiza_saldo_total();
				destino.atualiza_saldo_total();
				System.out.println("Transferencia realizada com sucesso");	
			}else {
				Double restante = this.getSaldo() - valor;
				this.limite = this.getLimite() + restante;
				this.saldo = 0.0;
				destino.saldo = destino.getSaldo() + valor;
				this.atualiza_saldo_total();
				destino.atualiza_saldo_total();
				System.out.println("Transferencia realizada com sucesso");
			}
	}else {
		System.out.println("Saque não realizado tente novamente");
	}
	}
}
		