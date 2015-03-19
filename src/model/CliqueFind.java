package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.alg.BronKerboschCliqueFinder;

import persistence.CliqueDAO;
import util.JSON2Object;
import util.Object2JSON;
import elements.Clique;

public class CliqueFind {
	public Set<Node> findClique(String idNode) {
		//BronKerboschCliqueFinder nn = new BronKerboschCliqueFinder();
		CliqueDAO cd = new CliqueDAO();
		ArrayList<String> nodes = cd.findNodes(idNode);
		JSON2Object json2object = new JSON2Object();
		Set<Node> nodesAll = new HashSet<Node>();
		for(String node : nodes) {
			HashSet<Node> nns = (HashSet<Node>) json2object.deserializeObject(node, HashSet.class);
			nodesAll.addAll(nns);
		}
		return nodesAll;
	}
}
