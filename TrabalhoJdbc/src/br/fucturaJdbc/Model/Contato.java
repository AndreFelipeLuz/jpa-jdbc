package br.fucturaJdbc.Model;

import java.util.List;

public class Contato {
	
	private Long id;
	private Long idCliente;
	private String email;
	private String DDD;
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
