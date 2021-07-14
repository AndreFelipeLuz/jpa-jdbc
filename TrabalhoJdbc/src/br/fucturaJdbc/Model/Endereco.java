package br.fucturaJdbc.Model;

import java.util.List;

public class Endereco {
	
	private Long id;
	private Long idCliente;
	private String cep;
	private String rua;
	private String numero;
	private String bairo;
	private String cidade;
	private String estado;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairo() {
		return bairo;
	}
	public void setBairo(String bairo) {
		this.bairo = bairo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", bairo=" + bairo
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
	public void toStringList(List<Endereco> endereco ,long a,boolean b) {
		if (b) {
			for (int i = 0; i < endereco.size(); i++) {
				if (endereco.get(i).getIdCliente() == a) {
				System.out.println(endereco.get(i).toString()); 
				} 
			}	
		}
		else {
			for (int i = 0; i < endereco.size(); i++) {
				System.out.println(endereco.get(i).toString());  
			}
		}
	}
}
