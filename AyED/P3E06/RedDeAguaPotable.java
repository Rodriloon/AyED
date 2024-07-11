package P3E06;
import java.util.List;
import P1E08.Queue;
import P3E04.AreaEmpresa;
import P3demo.GeneralTree;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> AG;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.AG = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		GeneralTree<Character> GT = AG;
		if ((!GT.isEmpty()) && (GT != null))
			return miniminho(GT, caudal);
		else
			return -1;
	}
	
	private double miniminho (GeneralTree<Character> GT, double caudal) {
		double cantPerCaudal = caudal % GT.getChildren().size();
		double caudalMin = Double.MAX_VALUE;
		for (GeneralTree<Character> hijos: GT.getChildren()) {
			double caudalHijo = miniminho(hijos, cantPerCaudal);
			caudalMin = Math.min(caudalMin, caudalHijo);
		}
		return caudalMin;
	}

}
