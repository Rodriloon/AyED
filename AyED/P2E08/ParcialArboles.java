package P2E08;
import P2Demo.BinaryTree;

/*
 Escribir en una clase ParcialArboles el método público con la siguiente firma:
public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
 El método devuelve true si arbol1 es prefijo de arbol2, false en caso contrario.
 Se dice que un árbol binario arbol1 es prefijo de otro árbol binario arbol2, cuando arbol1 coincide
con la parte inicial del árbol arbol2 tanto en el contenido de los elementos como en su estructura.
 */

public class ParcialArboles {
	

	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1 == null || arbol1.isEmpty() || arbol2 == null || arbol2.isEmpty())
			return false;
		else
			return HelperEsPrefijo(arbol1,arbol2);	
	}
	
	private boolean HelperEsPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean res = true;
		BinaryTree<Integer> nodo1 = arbol1;
		BinaryTree<Integer> nodo2 = arbol2;
		if (nodo1.getData() != nodo2.getData())
			return false; 
		if(nodo1.hasLeftChild()) {
            if(nodo2.hasLeftChild())
                res =HelperEsPrefijo(nodo1.getLeftChild(), nodo2.getLeftChild()); 
            else
            	return false;
		}
		if(nodo1.hasRightChild()) {
            if(nodo2.hasRightChild())
                res = HelperEsPrefijo(nodo1.getRightChild(), nodo2.getRightChild()); 
            else
            	return false;
        }
		return res;
	}
}
