package view;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Teste {

	public static void main(String[] args) {
		Cliente cli = new Cliente("Irineu", "a@teste.com", "222.222.222-22", Utils.string_data("25/10/1990"));
		Cliente cli2 = new Cliente("Testineu", "teste@teste.com", "333.333.333-33", Utils.string_data("05/07/1998"));
		
		//System.out.println(cli);
		//System.out.println(cli2);
		
		Conta con1 = new Conta(cli);
		Conta con2 = new Conta(cli2);
		
		con1.depositar(500.00);
		con2.depositar(300.00);
		
		//con1.depositar(0.0);
		//con2.depositar(-100.00);
		
		//con1.sacar(200.00);
		
		//con1.sacar(-10.0);
		
		
		//con1.setLimite(300.0);
		//con1.sacar(700.00);
		
		con1.transferir(con2, 250.0);
		
		
		System.out.println(con1);
		System.out.println();
		System.out.println(con2);
	
	}

}
