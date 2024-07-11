package P3E07;
import java.util.LinkedList;
import java.util.List;
import P3demo.GeneralTree;

public class Caminos {
	
	private GeneralTree<Integer> AG;
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.AG = arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> camino = new LinkedList<Integer>();
		List<Integer> aux = new LinkedList<Integer>();
		GeneralTree<Integer> GT = AG;
		if ((!GT.isEmpty()) && (GT != null))
			caminoAHojaMasLejana(GT, camino, aux);
		return camino;
	}
	
	public void caminoAHojaMasLejana (GeneralTree<Integer> GT, List<Integer> camino, List<Integer> actual){
		actual.add(GT.getData());
		if (!GT.isLeaf()) {
			for(GeneralTree<Integer> hijos: GT.getChildren())
				caminoAHojaMasLejana(hijos, camino, actual);
		}
		else {
			if (actual.size() > camino.size()) {
				camino.removeAll(camino);
				camino.addAll(actual);
			}
		}
		actual.remove(actual.size() - 1);
	}

}
