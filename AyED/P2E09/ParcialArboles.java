package P2E09;
import P2Demo.BinaryTree;

/*
 Escribir en una clase ParcialArboles el método público con la siguiente firma:
public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol)
 El método recibe un árbol binario de enteros y devuelve un nuevo árbol que contenga en cada
nodo dos tipos de información:
● La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.
● La diferencia entre el número almacenado en el nodo original y el número almacenado en el nodo padre.
 */

public class ParcialArboles {
	
	public BinaryTree<SumaDiferencia> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<SumaDiferencia> resultado = new BinaryTree<SumaDiferencia>();
		if ((arbol != null) && (!arbol.isEmpty()))
			HelperSumAndDif(arbol, resultado, 0 , 0);
		return resultado;
	}
	
	public void HelperSumAndDif(BinaryTree<Integer> arbol, BinaryTree<SumaDiferencia> resultado, int suma, int diferencia){
		int valorActual = arbol.getData();
	    int sumaActual = suma + valorActual;
	    int difActual = valorActual - diferencia;
	    SumaDiferencia objeto = new SumaDiferencia(sumaActual, difActual);
	    resultado.setData(objeto);
		if(arbol.hasLeftChild()) {
	        BinaryTree<SumaDiferencia> hijoIzq = new BinaryTree<SumaDiferencia>();
	        resultado.addLeftChild(hijoIzq);
	        HelperSumAndDif(arbol.getLeftChild(), hijoIzq, suma, valorActual);
	    }
	    if(arbol.hasRightChild()) {
	        BinaryTree<SumaDiferencia> hijoDer = new BinaryTree<SumaDiferencia>();
	        resultado.addRightChild(hijoDer);
	        HelperSumAndDif(arbol.getRightChild(), hijoDer, suma, valorActual);
	    }
	}
	
}
