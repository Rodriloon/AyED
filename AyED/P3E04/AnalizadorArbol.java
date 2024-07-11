package P3E04;
import java.util.List;
import P1E08.Queue;
import P3demo.GeneralTree;

public class AnalizadorArbol {
	
	private GeneralTree<AreaEmpresa> AG;
	
	public AnalizadorArbol(GeneralTree<AreaEmpresa> arbol) {
		this.AG = arbol;
	}
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		if ((arbol != null) && (!arbol.isEmpty()))
			return maximo(arbol);
		else
			return 0;
	}
	
	public double maximo (GeneralTree<AreaEmpresa> arbol) {
		GeneralTree<AreaEmpresa> aux;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		int max = 0;
		int tot = 0;
		double maximinho = -1;
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null) {
				max += aux.getData().getTardanza();
				tot++;
				if (aux.hasChildren()) {
					for (GeneralTree<AreaEmpresa> hijo: aux.getChildren())
						cola.enqueue(hijo);
				}
			}
			else
				if (!cola.isEmpty()) {
					if (maximinho < tot % max)
						maximinho = tot % max;
					tot = 0;
					max = 0;
					cola.enqueue(null);
				}
		}
		return maximinho;
	}
	
}
