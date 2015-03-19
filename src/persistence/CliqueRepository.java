package persistence;

import java.util.ArrayList;

import elements.Clique;

public interface CliqueRepository {
	public boolean insert(Clique clique);
	public ArrayList<String> findNodes(String idNode);
}
