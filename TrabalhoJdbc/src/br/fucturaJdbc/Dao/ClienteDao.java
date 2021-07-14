package br.fucturaJdbc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fucturaJdbc.JDBCUtil.ConecxaoJDBC;
import br.fucturaJdbc.Model.Cliente;

public class ClienteDao {

	Connection conexao;
	PreparedStatement ps;
	String sql;
		
	public void insert(Cliente cliente) throws SQLException {
		
		String sql = "insert into CLIENTE (NOME,CPF,ANODENASCI,SEXO) values (?,?,?,?)";
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);	
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCPF());
			ps.setString(3, cliente.getAnoNasci());
			ps.setString(4, cliente.getSexo());
			
			ps.execute();
			System.out.println("pegou :>");
		//	conexao.commit();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
	}
	public void delete(Cliente cliente) throws SQLException {
		sql = "delete CLIENTE where ID_CLIENTE = ?";
			try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);
				ps.setLong(1, cliente.getId());
				
			ps.execute();
			System.out.println("pegou :>");
			} catch (SQLException e) {
				 e.printStackTrace();
		}
	}
	public void uptade(Cliente cliente) throws SQLException {
		sql = "UPDATE CLIENTE SET NOME=? ,CPF=? ,SEXO=? ,ANODENASCI=? WHERE ID_CLIENTE = ?";
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);		
			
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getCPF());
				ps.setString(3, cliente.getSexo());
				ps.setString(4, cliente.getAnoNasci());
				ps.setLong(5, cliente.getId());
				
			ps.execute();
			System.out.println("pegou :>");
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public List<Cliente> select() throws SQLException {
		sql = "SELECT * FROM CLIENTE";
		List<Cliente> listarPessoas = new ArrayList<Cliente>();
		
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultado.getLong("ID_CLIENTE"));
				cliente.setNome(resultado.getString("NOME"));
				cliente.setCPF(resultado.getString("CPF"));
				cliente.setSexo(resultado.getString("SEXO"));
				cliente.setAnoNasci(resultado.getString("ANODENASCI"));
				
				
				listarPessoas.add(cliente);
			}
		ps.execute();

			} catch (SQLException e) {
				 e.printStackTrace();
		}
		return listarPessoas;
	}

}
