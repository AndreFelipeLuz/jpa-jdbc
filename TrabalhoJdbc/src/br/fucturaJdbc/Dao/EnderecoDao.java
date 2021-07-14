package br.fucturaJdbc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fucturaJdbc.JDBCUtil.ConecxaoJDBC;
import br.fucturaJdbc.Model.Endereco;

public class EnderecoDao {
	Connection conexao;
	PreparedStatement ps;
	String sql;
		
	public void insert(Endereco endereco) throws SQLException {
		
		String sql = "insert into ENDERECO (BAIRO,CEP,CIDADE,ESTADO,NUMERO,RUA,IDCLIENTE) values (?,?,?,?,?,?,?)";
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);	
			
			ps.setString(1, endereco.getBairo());
			ps.setString(2, endereco.getCep());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getEstado());
			ps.setString(5, endereco.getNumero());
			ps.setString(6, endereco.getRua());
			ps.setLong(7, endereco.getIdCliente());
			
			ps.execute();
			System.out.println("pegou :>");
		//	conexao.commit();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
	}
	public void delete(Endereco endereco) throws SQLException {
		sql = "delete ENDERECO where ID_ENDERECO = ?";
			try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);
				ps.setLong(1, endereco.getId());
				
			ps.execute();
			System.out.println("pegou :>");
			} catch (SQLException e) {
				 e.printStackTrace();
		}
	}
	public void uptade(Endereco endereco) throws SQLException {
		sql = "UPDATE ENDERECO SET BAIRO=? ,CEP=? ,CIDADE=? ,ESTADO=? ,NUMERO=?, RUA=? WHERE ID_ENDERECO = ?";
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);		
			
				ps.setString(1, endereco.getBairo());
				ps.setString(2, endereco.getCep());
				ps.setString(3, endereco.getCidade());
				ps.setString(4, endereco.getEstado());
				ps.setString(5, endereco.getNumero());
				ps.setString(6, endereco.getRua());
				ps.setLong(7, endereco.getId());
				
			ps.execute();
			System.out.println("pegou :>");
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public List<Endereco> select() throws SQLException {
		sql = "SELECT * FROM ENDERECO";
		List<Endereco> listarPessoas = new ArrayList<Endereco>();
		
		try {
			conexao = ConecxaoJDBC.getConexao();
			ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(resultado.getLong("ID_ENDERECO"));
				endereco.setIdCliente(resultado.getLong("IDCLIENTE"));
				endereco.setBairo(resultado.getString("BAIRO"));
				endereco.setCep(resultado.getString("CEP"));
				endereco.setCidade(resultado.getString("CIDADE"));
				endereco.setEstado(resultado.getString("ESTADO"));
				endereco.setNumero(resultado.getString("NUMERO"));
				endereco.setRua(resultado.getString("RUA"));
				
				listarPessoas.add(endereco);
			}
		ps.execute();

			} catch (SQLException e) {
				 e.printStackTrace();
		}
		return listarPessoas;
	}
}
