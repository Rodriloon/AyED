package P2E05;
import java.util.*;
import P2demo.BinaryTree;

public class ProfundidadDeArbolBinario {
	
	private BinaryTree<Integer> AB;
	
	public ProfundidadDeArbolBinario (BinaryTree ab) {
		this.AB = ab;
	}
	
	public int sumaElementosProfundidad (int p) {
		return (!AB.isEmpty()) ? sumaElementosProfundidad(p, AB, 0): 0;
	}
	
	public int sumaElementosProfundidad (int p, BinaryTree<Integer> ab, int nivelAct) {
		if (p == nivelAct) {
			return ab.getData();
		}
		else {
			int suma = 0;
			if(ab.hasLeftChild()) 
				suma+= sumaElementosProfundidad(p, ab.getLeftChild(), nivelAct + 1);
	        if(ab.hasRightChild()) 
	        	suma+= sumaElementosProfundidad(p, ab.getRightChild(), nivelAct + 1);
			return suma;
		}
	}
	
	public static void main (String[] args) {
		
		System.out.println("Test suma de todos los nodos del árbol en la profundidad pasada.");
		BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
		ab.addLeftChild(new BinaryTree<Integer>(2));
	    ab.addRightChild(new BinaryTree<Integer>(6));
	    ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
	    ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
	    ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
	    ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
	    
	    ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
	    System.out.println(prof.sumaElementosProfundidad(2));
		
	}
	
}
