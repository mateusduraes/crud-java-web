package modelo;

import java.util.Calendar;

public class Cliente extends Pessoa {

	private String cpf;

	public Cliente(Integer id, String nome, String endereco, Calendar dataCadastro, String cpf) {
		super(id, nome, endereco, dataCadastro);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
	
	

}
