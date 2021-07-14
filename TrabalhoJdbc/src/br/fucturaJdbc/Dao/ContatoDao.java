package br.fucturaJdbc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fucturaJdbc.JDBCUtil.ConecxaoJDBC;
import br.fucturaJdbc.Model.Contato;

public class ContatoDao {

	Connection conexao;
	PreparedStatement ps;
	String sql;
		
	public void insert(Contato contato) throws SQLException {
		
		String sql = "insert into CONTATO (DDD,EMAIL,NUMERO,IDCLIENTE) values (?,?,?,?)";
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);	
			
			ps.setString(1, contato.getDDD());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getNumero());
			ps.setLong(4, contato.getIdCliente());
			
			
			ps.execute();
			System.out.println("pegou :>");
		//	conexao.commit();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
	}
	public void delete(Contato contato) throws SQLException {
		sql = "delete CONTATO where ID_CONTATO = ?";
			try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);
				ps.setLong(1, contato.getId());
				
			ps.execute();
			System.out.println("pegou :>");
			} catch (SQLException e) {
				 e.printStackTrace();
		}
	}
	public void uptade(Contato contato) throws SQLException {
		sql = "UPDATE CONTATO SET DDD=? ,EMAIL=? ,NUMERO=? WHERE ID_CONTATO = ?";
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);		
			
				ps.setString(1, contato.getDDD());
				ps.setString(2, contato.getEmail());
				ps.setString(3, contato.getNumero());
				ps.setLong(4, contato.getId());

			System.out.println("pegou :>");
			ps.execute();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public List<Contato> select() throws SQLException {
		sql = "SELECT * FROM CONTATO";
		List<Contato> listarPessoas = new ArrayList<Contato>();
		
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				Contato contato = new Contato();
				contato.setId(resultado.getLong("ID_CONTATO"));
				contato.setIdCliente(resultado.getLong("IDCLIENTE"));
				contato.setDDD(resultado.getString("DDD"));
				contato.setEmail(resultado.getString("EMAIL"));
				contato.setNumero(resultado.getString("NUMERO"));
				
				listarPessoas.add(contato);
			
			}
		ps.execute();

			} catch (SQLException e) {
				 e.printStackTrace();
		}
		return listarPessoas;
	}
}
