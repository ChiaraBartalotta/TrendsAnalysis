package test;

import java.util.Collection;
import java.util.Set;

import model.CliqueFind;
import model.CliqueMaker;
import model.Node;
import model.UndirectGraph;
import util.FileManager;
import util.FileManagerInterface;
import util.JSON2Object;
import util.Object2JSON;

public class testFindClique {
	public static void main(String[] args) {
		CliqueFind cc= new CliqueFind();
		/*RelationshipGraph rg = new RelationshipGraph();
		UndirectGraph gh =rg.getGraph();*/
		Set<Node> nodes = cc.findClique("1");
		Object2JSON obj = new Object2JSON();
		String js = obj.serializeObject(nodes);
		System.out.println(js);
		/*List<Set<Node>> nns = new ArrayList<Set<Node>>();
		nns.addAll((Collection<? extends Set<Node>>) nodes);
		//nns.get(0).retainAll(nns.get(1));
		System.out.println(nns.toString());*/
	}
}
