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
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE.AUTO)
	@Column(name = "id_endereco")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@Column(name = "idcliente")
	private Long idCliente;
	@Column(name = "cep",nullable = false,length = 22)
	private String cep;
	@Column(name = "rua",nullable = false,length = 22)
	private String rua;
	@Column(name = "numero",nullable = false,length = 22)
	private String numero;
	@Column(name = "bairo",nullable = false,length = 22)
	private String bairo;
	@Column(name = "cidade",nullable = false,length = 22)
	private String cidade;
	@Column(name = "estado",nullable = false,length = 22)
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
		return "Endereco [id=" + id + ", idCliente=" + idCliente + ", cep=" + cep + ", rua=" + rua + ", numero="
				+ numero + ", bairo=" + bairo + ", cidade=" + cidade + ", estado=" + estado + "]";
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
