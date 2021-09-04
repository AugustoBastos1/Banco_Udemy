package model;

import java.util.Date;

import helper.Utils;

/**
Metodo construtor da classe Cliente
*/
public class Cliente {
	private static int contador = 101;
	private int id;
	private String nome;
	private String email;
	private String cpf;
	private Date data_nascimento;
	private Date data_cadastro;
	
	public Cliente(String nome, String email, String cpf, Date data_nascimento) {
		this.id = contador;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.data_cadastro = new Date();
		contador++;
	}
	/*
	 Getters e setters de todos os atributos
	*/
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getData_nascimento() {
		return data_nascimento;
	}
	
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}
	
	
	/**
	 Sobrescreve o metodo "To String" de uma instancia de Cliente
	 */
	public String toString() {
		return "ID: " + this.getId() + "\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + 
				"\nEmail: " + this.getEmail() + "\nData de nascimento: " + Utils.data_string(this.getData_nascimento()) +
				"\nData de cadastro: " + Utils.data_string(this.getData_cadastro());
	}

}
