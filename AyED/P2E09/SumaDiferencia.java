package P2E09;

public class SumaDiferencia {
	
	private int suma; /*La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.*/
	private int diferencia; /*La diferencia entre el número almacenado en el nodo original y el número almacenado en el nodo padre*/
	
	public SumaDiferencia(int suma, int diferencia) {
		this.suma = suma;
		this.diferencia = diferencia;
	}
	
	public int getSuma() {
        return suma;
    }

    public int getDiferencia() {
        return diferencia;
    }
}
