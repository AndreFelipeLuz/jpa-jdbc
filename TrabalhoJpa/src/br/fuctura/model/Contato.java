package br.fuctura.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE.AUTO)
	@Column(name = "id_contato")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@Column(name = "idcliente")
	private Long idCliente;
	@Column(name = "email",nullable = false,length = 15)
	private String email;
	@Column(name = "DDD",nullable = false,length = 3)
	private String DDD;
	@Column(name = "numero",nullable = false,length = 12)
	private String numero;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDDD() {
		return DDD;
	}
	public void setDDD(String dDD) {
		DDD = dDD;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Contato [id=" + id + ", idCliente=" + idCliente + ", email=" + email + ", DDD=" + DDD + ", numero="
				+ numero + "]";
	}
	
	public void toStringList(List<Contato> contato,long a,boolean b) {
		 if (b) {
			 for (int i = 0; i < contato.size(); i++) {
				 if (contato.get(i).getIdCliente() == a) {
						System.out.println(contato.get(i).toString()); 
				 } 
			 }
		 }
		 else{
			 for (int i = 0; i < contato.size(); i++) {
				 	System.out.println(contato.get(i).toString()); 
		 	}
		}
	}
}
