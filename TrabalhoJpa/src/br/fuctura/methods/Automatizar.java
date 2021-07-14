package br.fuctura.methods;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.fuctura.JpaUtil.JPAUtil;
import br.fuctura.model.Cliente;
import br.fuctura.model.Contato;
import br.fuctura.model.Endereco;

public class Automatizar {
	private long a;
	private String b;
	private int c;
	private EntityManager entityManager = JPAUtil.getEntityManager();
	private EntityTransaction tx = entityManager.getTransaction();
	private Scanner ler = new Scanner(System.in);
	private Cliente cliente = new Cliente();
	private Contato contato = new Contato();
	private Endereco endereco = new Endereco();
	private List<Cliente> listacliente;
	private List<Contato> listacontato;
	private List<Endereco> listaendereco;
	Query query;
	
	public void getListarTodos(){
		
		tx.begin();
		query = entityManager.createQuery("from cliente p");
		listacliente = query.getResultList();
		query = entityManager.createQuery("from contato p");
		listacontato = query.getResultList();
		query = entityManager.createQuery("from endereco p");
		listaendereco = query.getResultList();
		cliente.toStringList(listacliente);
		System.out.println("coloque o id da pessoa que deseja visualizar a lista de contatos e lista de endereços.");
		a = ler.nextLong();
		System.out.println("==========-Lista De Contatos-==========");
		contato.toStringList(listacontato, a,true);
		System.out.println("==========-Lista De Endereços-==========");
		endereco.toStringList(listaendereco, a,true);
		tx.commit();
		entityManager.close();
		JPAUtil.close();
		
	}
	
	public void escolherInsercao() {
		
		query = entityManager.createQuery("from cliente p");
		listacliente = query.getResultList();
		System.out.println("por favor escolha uma das 3 opção abaixo");
		System.out.println("1-Cliente");
		System.out.println("2-Contato");
		System.out.println("3-Endereço");	
		c = ler.nextInt();
		tx.begin();
		switch (c) {
		case 1:
			
			System.out.println("insira as informações");
			System.out.println("digite seu nome");
			b = ler.next();
			cliente.setNome(b);
			System.out.println("digite seu cpf");
			b = ler.next();
			cliente.setCPF(b);
			System.out.println("digite seu Ano de Nascimento");
			b = ler.next();
			cliente.setAnoNasci(b);
			System.out.println("se você for homem escreva M se for mulher F.");
			b = ler.next();
			cliente.setSexo(b);
			entityManager.merge(cliente);
			break;
		case 2:
			
			System.out.println("todos os clientes");
			cliente.toStringList(listacliente);
			System.out.println("coloque o id da pessoa que deseja adicionar a lista de contatos.");
			a = ler.nextLong();
			contato.setIdCliente(a);
			System.out.println("digite seu DDD");
			b = ler.next();
			contato.setDDD(b);
			System.out.println("digite seu Email");
			b = ler.next();
			contato.setEmail(b);
			System.out.println("digite seu Numero");
			b = ler.next();
			contato.setNumero(b);
			entityManager.merge(contato);
			break;
		case 3:
			
			System.out.println("todos os clientes");
			cliente.toStringList(listacliente);
			System.out.println("coloque o id da pessoa que deseja adicionar a lista de Endereços.");
			a = ler.nextLong();
			endereco.setIdCliente(a);
			System.out.println("digite seu bairo");
			b = ler.next();
			endereco.setBairo(b);
			System.out.println("digite seu CEP");
			b = ler.next();
			endereco.setCep(b);
			System.out.println("digite sua Cidade");
			b = ler.next();
			endereco.setCidade(b);
			System.out.println("digite seu Estado");
			b = ler.next();	
			endereco.setEstado(b);
			System.out.println("digite seu Numero");
			b = ler.next();
			endereco.setNumero(b);
			System.out.println("escreva sua rua");
			b = ler.next();
			endereco.setRua(b);
			entityManager.merge(endereco);
			break;
		default:escolherInsercao();
			break;
		}
		tx.commit();
		entityManager.close();
		JPAUtil.close();
	}
	public void escolherDeletar() {
		
		tx.begin();
		query = entityManager.createQuery("from cliente p");
		listacliente = query.getResultList();
		query = entityManager.createQuery("from contato p");
		listacontato = query.getResultList();
		query = entityManager.createQuery("from endereco p");
		listaendereco = query.getResultList();
		System.out.println("Oque desejas Deletar?");
		System.out.println("1-Cliente");
		System.out.println("2-Contato");
		System.out.println("3-Endereço");
		int c = ler.nextInt();
		
	switch (c) {
	case 1:
		cliente.toStringList(listacliente);
		System.out.println("escolha qual cliente quer deletar");
		a = ler.nextLong();
		cliente.setId(a);
		entityManager.remove(cliente);
		break;
	case 2:
		contato.toStringList(listacontato, 0, false);
		System.out.println("escolha qual contato quer deletar");
		a = ler.nextLong();
		contato.setId(a);
		entityManager.remove(contato);
	 	break;
	case 3:
		endereco.toStringList(listaendereco, 0, false);
		System.out.println("escolha qual endereco quer deletar");
		a = ler.nextLong();
		endereco.setId(a);
		entityManager.remove(endereco);
		break;
	default:
		escolherDeletar();
		break;
		}	
		tx.commit();
		entityManager.close();
		JPAUtil.close();
	}
	
	public void escolherAtualizar() {
		tx.begin();
		query = entityManager.createQuery("from cliente p");
		listacliente = query.getResultList();
		query = entityManager.createQuery("from contato p");
		listacontato = query.getResultList();
		query = entityManager.createQuery("from endereco p");
		listaendereco = query.getResultList();
		System.out.println("Oque desejas Atualizar?");
		System.out.println("1-Cliente");
		System.out.println("2-Contato");
		System.out.println("3-Endereço");
		c = ler.nextInt();
		switch (c) {
		case 1:
			cliente.toStringList(listacliente);
			System.out.println("escolha qual cliente quer atualizar");
			a = ler.nextLong();
			cliente.setId(a);
			System.out.println("insira as informações da atualização");
			System.out.println("digite seu nome");
			b = ler.next();
			cliente.setNome(b);
			System.out.println("digite seu cpf");
			b = ler.next();
			cliente.setCPF(b);
			System.out.println("digite seu Ano de Nascimento");
			b = ler.next();
			cliente.setAnoNasci(b);
			System.out.println("se você for homem escreva M se for mulher F.");
			b = ler.next();
			cliente.setSexo(b);
			entityManager.persist(cliente);
			break;
		case 2:
			contato.toStringList(listacontato, 0, false);
			System.out.println("escolha qual contato quer atualizar");
			a = ler.nextLong();
			contato.setId(a);
			System.out.println("insira as informações da atualização");
			System.out.println("digite seu DDD");
			b = ler.next();
			contato.setDDD(b);
			System.out.println("digite seu Email");
			b = ler.next();
			contato.setEmail(b);
			System.out.println("digite seu Numero");
			b = ler.next();
			contato.setNumero(b);
			entityManager.persist(contato);
			break;
		case 3:
			System.out.println("escolha qual endereco quer Atualizar");
			a = ler.nextLong();
			endereco.setId(a);
			System.out.println("insira as informações da atualização");
			System.out.println("digite seu bairo");
			b = ler.next();
			endereco.setBairo(b);
			System.out.println("digite seu CEP");
			b = ler.next();
			endereco.setCep(b);
			System.out.println("digite sua Cidade");
			b = ler.next();
			endereco.setCidade(b);
			System.out.println("digite seu Estado");
			b = ler.next();	
			endereco.setEstado(b);
			System.out.println("digite seu Numero");
			b = ler.next();
			endereco.setNumero(b);
			System.out.println("escreva sua rua");
			b = ler.next();
			endereco.setRua(b);
			entityManager.persist(endereco);
			break;
		default:
			escolherAtualizar();
			break;
		}
		tx.commit();
		entityManager.close();
		JPAUtil.close();
	}
}
