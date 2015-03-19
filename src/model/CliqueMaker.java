package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.*;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import elements.Clique;
import persistence.CliqueDAO;
import util.JSON2Object;
import util.Object2JSON;

public class CliqueMaker {
	
	
	/*
	public void makeCliques(JSONObject map) {
		HashMap<String, HashSet<String>> result; 
		JSON2Object json2Object = new JSON2Object();
		result = (HashMap<String, HashSet<String>>) json2Object.deserializeObject(map.toJSONString(), HashMap.class);
		List<String> taboo = findNodeGreater(result, 4);
	}
	
	public List<String> findNodeGreater(HashMap<String, HashSet<String>> map, int m) {
		List<String> taboo = new ArrayList<String>();
		for (String el : map.keySet()) {
			if (map.get(el).size()>=m)
				taboo.add(el);
		}
		return taboo;
	}*/
	public Collection<Set<Node>> makeCliques(UndirectGraph gg) {
		//BronKerboschCliqueFinder nn = new BronKerboschCliqueFinder();
		CliqueDAO cd = new CliqueDAO();
		Set<Node> nodeTaboo = gg.tabooList(4);
		HashMap<String, HashSet<String>> result; 
		JSON2Object json2Object = new JSON2Object();
		Object2JSON object2json = new Object2JSON();
		//result = (HashMap<String, HashSet<String>>) json2Object.deserializeObject(map.toJSONString(), HashMap.class);
		BronKerboschCliqueFinder<Node, UndirectEdge> fgh = new BronKerboschCliqueFinder<Node, UndirectEdge>(gg);
		Collection<Set<Node>> nodes = fgh.getAllMaximalCliques();
		for(Node nn : nodeTaboo) {
			for(Set<Node> cand : nodes) {
				if (cand.contains(nn)) {
					String nodesString = object2json.serializeObject(cand);
					Clique cc = new Clique(nn.getName(), nodesString);
					cd.insert(cc);
				}		
			}
		}
		//Collection<Set<Node>> nodes2 =  fgh.getBiggestMaximalCliques();
		return nodes;
		
	}
}
