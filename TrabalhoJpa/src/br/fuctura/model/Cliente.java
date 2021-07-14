package br.fuctura.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE.AUTO)
	@Column(name = "id_cliente")
	private Long id;
	@Column(name = "nome",nullable = false,length = 45)
	private String nome;
	@Column(name = "anonasci",nullable = false,length = 4)
	private String anoNasci;
	@Column(name = "sexo",nullable = false,length = 1)
	private String sexo;
	@Column(name = "cpf",nullable = false,length = 15)
	private String CPF;
	
	public Long getId() {
		return id;
	}
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
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", anoNasci=" + anoNasci + ", sexo=" + sexo + ", CPF=" + CPF
				+ "]";
	}
	
	public void toStringList(List<Cliente> cliente) {
		 for (int i = 0; i < cliente.size(); i++) {
			System.out.println(cliente.get(i).toString());
	 	}
	}
}
