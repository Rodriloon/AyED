package P2E07;
import P2Demo.BinaryTree;

/*
 Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia de tipo
BinaryTree de valores enteros NO repetidos y el método público con la siguiente firma:
public boolean isLeftTree (int num)
 El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una
cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso
contrario. Consideraciones:
● Si “num” no se encuentra en el árbol, devuelve false.
● Si el árbol con raíz “num” no cuenta con una de sus ramas, considere que en esa rama hay -1 árboles con único hijo.
 */

public class ParcialArboles {
	
	private BinaryTree<Integer> arbol;


	public boolean isLeftTree(int num) {
		boolean aux = false;
		if  (!this.arbol.isEmpty()) {
			BinaryTree<Integer> nodo = buscar(num, this.arbol);
			if (nodo!= null) {
				int hi = 0; 
				int hd = 0; 
				if (nodo.hasLeftChild()) {
					hi = contar(nodo.getLeftChild());
				}
				if (nodo.hasRightChild()) {
					hd = contar(nodo.getRightChild());
				}
				if (hi>hd) {
					aux = true; 
				}
			}
		}
		return aux;
	}
	
	public BinaryTree<Integer> buscar(int num, BinaryTree<Integer> arbol){
		BinaryTree<Integer> dato = arbol;                               
		if(dato.isEmpty() || dato.getData() == num) {
			return dato;
		}
		if(dato.hasLeftChild()) {
			BinaryTree<Integer> izq = buscar(num, dato.getLeftChild());
			if (izq != null) {
				return izq; 
			}
		}
		if(dato.hasRightChild()) {    
			BinaryTree<Integer> der = buscar(num, dato.getRightChild());
			if (der != null) {
				return der; 
			}
		}
	    return null;
			
	}
	
	public int contar(BinaryTree<Integer> arboll) {
		int unhijo = 0; 
		if (arboll.hasLeftChild()) {
			unhijo += contar(arboll.getLeftChild());
		}
		if (arboll.hasRightChild()) {
			unhijo += contar(arboll.getRightChild()); 
		}
		if((arboll.hasLeftChild() && !arboll.hasRightChild()) || (!arboll.hasLeftChild() && arboll.hasRightChild())) {
			unhijo++;
		}
		return unhijo; 
	}
	
}