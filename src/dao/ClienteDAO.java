package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import modelo.Cliente;
import util.Utilitarios;

public class ClienteDAO implements DAO<Cliente> {

	private Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void adiciona(Cliente cliente) {
		String sql = "insert into clientes (nome, endereco, cpf, dataCadastro) values (?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEndereco());
			preparedStatement.setString(3, cliente.getCpf());
			preparedStatement.setDate(4, Utilitarios.converteDataParaSQL(cliente.getDataCadastro()));
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer id) {
		String sql = "delete from clientes where id = ?";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sql)) {
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void altera(Cliente cliente) {
		String sql = "update clientes set nome = ?, endereco = ?, cpf = ? where id = ?";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sql)) {
			prepareStatement.setString(1, cliente.getNome());
			prepareStatement.setString(2, cliente.getEndereco());
			prepareStatement.setString(3, cliente.getCpf());
			prepareStatement.setInt(4, cliente.getId());
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cliente> getLista() {
		List<Cliente> clientes = new ArrayList<>();
				
		try(PreparedStatement preparedStatement =  this.connection.prepareStatement("select * from clientes")){
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				while(resultSet.next()){
					String nome = resultSet.getString("nome");
					String endereco = resultSet.getString("endereco");
					String cpf = resultSet.getString("cpf");
					Integer id = resultSet.getInt("id");
					Calendar dataCadastro = Utilitarios.converteSQLParaCalendar(resultSet.getDate("dataCadastro"));
					
					Cliente cliente = new Cliente(id, nome, endereco, dataCadastro, cpf);
					clientes.add(cliente);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		return clientes;
	}

}
