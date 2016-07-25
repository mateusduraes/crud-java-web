package modelo;

import java.util.Calendar;

public class Pessoa {
	private Integer id;
	private String nome;
	private String endereco;
	private Calendar dataCadastro;	
	
	public Pessoa(Integer id, String nome, String endereco, Calendar dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public Integer getId() {
		return id;
	}

}
