package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunosJdbcDAO {

	private Connection conn;
	
	public AlunosJdbcDAO (Connection conn) {
		this.conn = conn;
	}

	public void salvar (Aluno a) throws SQLException {
		String sql = "INSERT INTO aluno (nome, endereco, bairro) VALUES (?,?,?)";
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.setString(1, a.getNome());
		prepareStatement.setString(2, a.getEndereco());
		prepareStatement.setString(3, a.getBairro());
		prepareStatement.execute();
		System.out.println("Aluno inserido com sucesso!\n");
		prepareStatement.close();
	}
	
	//VER O QUE VOU FAZER COM ESSE MÉTODO...
//	public void alterar(Aluno a) {
//		String sql = "UPDATE aluno SET bairro = ? WHERE id = 5";
//		System.out.println(sql);
//		PreparedStatement prepareStatement;
//		try {
//			prepareStatement = this.conn.prepareStatement(sql);
//			prepareStatement.setString(1, a.getBairro());
//			prepareStatement.executeUpdate();	
//			System.out.println("Aluno id " + a.getId() + " alterado com sucesso!\n" );
//			prepareStatement.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void alterarPorId(Aluno a, int id) {
		String sql = "UPDATE aluno SET nome = ?, endereco = ?, bairro = ? WHERE id = 5";
		//System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.setString(1, a.getNome());
			prepareStatement.setString(2, a.getEndereco());
			prepareStatement.setString(3, a.getBairro());
			prepareStatement.executeUpdate();
			System.out.println("Aluno id " + id + " alterado com sucesso!\n" );
			prepareStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir (int id) {
		String sql = "DELETE FROM aluno WHERE id=" + id;
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			System.out.println("Aluno id " + id + " deletado com sucesso!\n");
			prepareStatement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> pesquisarPorNome(String nome) {
		String sql = "SELECT * FROM aluno WHERE nome = ?";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.setString(1, nome);
			ResultSet rs = prepareStatement.executeQuery();	
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setEndereco(rs.getString("endereco"));
				a.setBairro(rs.getString("bairro"));
				alunos.add(a);
			}	
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
	
	public List<Aluno> listar(){
		String sql = "SELECT * FROM aluno";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				Aluno a = new Aluno();
				a.setId(id);
				a.setNome(nome);
				a.setEndereco(endereco);
				a.setBairro(bairro);
				alunos.add(a);
			}
			prepareStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
	
	
}









