package br.fucturaJdbc.Model;

import java.util.List;

public class Cliente {
	
	private Long id;
	private String nome;
	private String anoNasci;
	private String sexo;
	private String CPF;
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAnoNasci() {
		return anoNasci;
	}
	public void setAnoNasci(String anoNasci) {
		this.anoNasci = anoNasci;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", anoNasci=" + anoNasci + ", sexo=" + sexo + ", CPF=" + CPF + "]";
	}
	
	public void toStringList(List<Cliente> cliente) {
	 for (int i = 0; i < cliente.size(); i++) {
		System.out.println(cliente.get(i).toString());
	 	}
	}
}
