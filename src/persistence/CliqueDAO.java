package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import elements.Clique;

public class CliqueDAO implements CliqueRepository {
	public boolean insert(Clique clique) {
		DataSource datasource = new DataSource();
		Connection connection=null;
		String insert = "insert into clique(id, greater_node_id, nodes) values(?,?,?)";
		PreparedStatement statement=null;
		try {
			connection = datasource.getConnection();
			statement = connection.prepareStatement(insert);
			IdBroker broker = new IdBroker();
			statement.setLong(1, broker.getId(connection));
			statement.setLong(2, Long.parseLong(clique.getGreater_node_id()));
			statement.setString(3, clique.getNodes());
			return statement.executeUpdate()!=0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				if (statement != null) 
					statement.close();
				if (connection!= null)
					connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public ArrayList<String> findNodes(String idNode) {
		DataSource datasource = new DataSource();
		Connection connection=null;
		ArrayList<String> nodes = new ArrayList<String>();
		String select = "select nodes from clique where greater_node_id = ?";
		PreparedStatement statement=null;
		try {
			connection = datasource.getConnection();
			statement = connection.prepareStatement(select);
			statement.setLong(1,Long.parseLong(idNode));
			ResultSet result = statement.executeQuery();
			while(result.next()){
				nodes.add(result.getString("nodes"));
			}
			
			return nodes;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if (statement != null) 
					statement.close();
				if (connection!= null)
					connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
