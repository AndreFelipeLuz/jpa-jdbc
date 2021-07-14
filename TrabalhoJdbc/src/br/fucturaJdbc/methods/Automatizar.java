package br.fucturaJdbc.methods;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.fucturaJdbc.Dao.ClienteDao;
import br.fucturaJdbc.Dao.ContatoDao;
import br.fucturaJdbc.Dao.EnderecoDao;
import br.fucturaJdbc.Model.Cliente;
import br.fucturaJdbc.Model.Contato;
import br.fucturaJdbc.Model.Endereco;

public class Automatizar {
	
	private long a;
	private String b;
	private Scanner ler = new Scanner(System.in);
	private ClienteDao clienteDao = new ClienteDao();
	private ContatoDao contatoDao = new ContatoDao();
	private EnderecoDao enderecoDao = new EnderecoDao();
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();
	private Contato contato = new Contato();
	private List<Cliente> listacliente;
	private List<Contato> listacontato;
	private List<Endereco> listaendereco;
	
	public void getListarTodos() throws SQLException {		
		listacliente = clienteDao.select();
		listacontato = contatoDao.select();
		listaendereco = enderecoDao.select();
		cliente.toStringList(listacliente);
		System.out.println("coloque o id da pessoa que deseja visualizar a lista de contatos e lista de endereços.");
		a = ler.nextLong();
		System.out.println("==========-Lista De Contatos-==========");
		contato.toStringList(listacontato, a,true);
		System.out.println("==========-Lista De Endereços-==========");
		endereco.toStringList(listaendereco, a,true);
	}
	
	public void escolherInsercao() throws SQLException {
		listacliente = clienteDao.select();
		System.out.println("por favor escolha uma das 3 opção abaixo");
		System.out.println("1-Cliente");
		System.out.println("2-Contato");
		System.out.println("3-Endereço");
		a = ler.nextLong();
		if (a == 1) {
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
		clienteDao.insert(cliente);
	}
		else if (a == 2) {
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
		contatoDao.insert(contato);
	}
		else if (a == 3) {
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
		enderecoDao.insert(endereco);
	}
		else {
			escolherInsercao();
		}
	}
	public void escolherDeletar() throws SQLException{
		listacliente = clienteDao.select();
		listacontato = contatoDao.select();
		listaendereco = enderecoDao.select();
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
		clienteDao.delete(cliente);
		break;
	case 2:
		contato.toStringList(listacontato, 0, false);
		System.out.println("escolha qual contato quer deletar");
		a = ler.nextLong();
		contato.setId(a);
		contatoDao.delete(contato);
	 	break;
	case 3:
		endereco.toStringList(listaendereco, 0, false);
		System.out.println("escolha qual endereco quer deletar");
		a = ler.nextLong();
		endereco.setId(a);
		enderecoDao.delete(endereco);
		break;
	default:
		escolherDeletar();
		break;
		}	
	}
	public void escolherAtualizar() throws SQLException{
		int c;
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
			clienteDao.uptade(cliente);
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
			contatoDao.uptade(contato);
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
			enderecoDao.uptade(endereco);
			break;
		default:
			escolherAtualizar();
			break;
		}
	}
}