package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.CliqueMaker;
import model.Node;
import model.RelationshipGraph;
import model.UndirectGraph;
import util.FileManager;
import util.FileManagerInterface;
import util.JSON2Object;
import util.Object2JSON;

public class testMakeClique {

	public static void main(String[] args) {
		CliqueMaker cc= new CliqueMaker();
		/*RelationshipGraph rg = new RelationshipGraph();
		UndirectGraph gh =rg.getGraph();*/
		JSON2Object jj = new JSON2Object();
		FileManagerInterface fr = new FileManager();
		String contain = fr.readFile("./src/file/graph.txt");
		//System.out.println(contain);
		UndirectGraph gh = (UndirectGraph) jj.deserializeObject(contain, UndirectGraph.class);
		Collection<Set<Node>> nodes = cc.makeCliques(gh);
		Object2JSON obj = new Object2JSON();
		String js = obj.serializeObject(nodes);
		/*FileManagerInterface ff = new FileManager();
		ff.createFile("./src/file/cliqueMaximal.txt", js);*/
		System.out.println(js);
		/*List<Set<Node>> nns = new ArrayList<Set<Node>>();
		nns.addAll((Collection<? extends Set<Node>>) nodes);
		//nns.get(0).retainAll(nns.get(1));
		System.out.println(nns.toString());*/
	}

}
