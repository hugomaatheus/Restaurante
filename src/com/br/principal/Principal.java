package com.br.principal;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.br.Service.ClienteController;
import com.br.model.Cliente;
import com.br.model.Endereco;



public class Principal {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		

		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		String nome, rua, num, telefone;
		
		nome = JOptionPane.showInputDialog("Informe o nome: ");
		rua = JOptionPane.showInputDialog("Informe a rua: ");
		num = JOptionPane.showInputDialog("Informe o número: ");
		telefone = JOptionPane.showInputDialog("Informe o telfone: ");
		
		cliente.setNome(nome);
		endereco.setRua(rua);
		endereco.setNumero(num);
		endereco.setTelefone(telefone);
		cliente.setEndereco(endereco);
		
		ClienteController.cadastrarCliente(cliente);
	}
}
